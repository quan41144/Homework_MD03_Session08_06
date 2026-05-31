package ra.hwss0801.service;

import ra.hwss0801.model.dto.request.ReaderCreateDTO;
import ra.hwss0801.model.entity.Reader;

public interface ReaderService {
    Reader createReader(ReaderCreateDTO readerCreateDTO);
}
