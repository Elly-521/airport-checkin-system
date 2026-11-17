package service;

// 負責：成員5（報到與行李）
// 報到失敗時丟出，例如超過報到時間、艙等不符、座位已被選走、行李超重
public class CheckInException extends Exception {
    public CheckInException(String message) {
        super(message);
    }
}
