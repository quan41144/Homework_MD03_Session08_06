package ra.hwss0801.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ra.hwss0801.exception.InvalidImageException;
import ra.hwss0801.model.dto.request.ReaderCreateDTO;
import ra.hwss0801.model.entity.Reader;
import ra.hwss0801.repository.ReaderRepository;
import ra.hwss0801.service.ReaderService;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class ReaderServiceImpl implements ReaderService {
    private final ReaderRepository readerRepository;
    private final Cloudinary cloudinary;
    @Override
    public Reader createReader(ReaderCreateDTO readerCreateDTO) {
        if (readerRepository.existsByEmail(readerCreateDTO.getEmail())) {
            throw new RuntimeException("Email đã tồn tại!");
        }
        MultipartFile file = readerCreateDTO.getAvatarFile();
        if (file == null || file.isEmpty()) {
            throw new InvalidImageException("File tải lên phải là hình ảnh (png, jpg, jpeg)!");
        }
        String originalFilename = file.getOriginalFilename();
        if (originalFilename == null ||
                (!originalFilename.toLowerCase().endsWith(".png") && !originalFilename.toLowerCase().endsWith(".jpg") && !originalFilename.toLowerCase().endsWith(".jpeg"))) {
            throw new InvalidImageException("File tải lên phải là hình ảnh (png, jpg, jpeg)!");
        }
        String cloudinaryUrl = "";
        try {
            Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            cloudinaryUrl = uploadResult.get("secure_url").toString();
        }
        catch (Exception e) {
            throw new RuntimeException("Xảy ra lỗi: " + e.getMessage());
        }
        Reader reader = Reader.builder()
                .email(readerCreateDTO.getEmail())
                .fullName(readerCreateDTO.getFullName())
                .phoneNumber(readerCreateDTO.getPhoneNumber())
                .address(readerCreateDTO.getAddress())
                .avatar(cloudinaryUrl)
                .build();
        return readerRepository.save(reader);
    }
}
