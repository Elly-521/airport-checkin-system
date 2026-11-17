package service;

import model.BoardingPass;

// 負責：E
public interface BoardingService {
    // 登機成功回傳 true
    boolean board(BoardingPass pass);
}
