# ✈️ Airport Check-in & Boarding System

OOP 課程期末分組專題：機場報到與登機系統

## 專案簡介

本系統管理旅客從**報到 → 選位 → 產生登機證 → 登機**的完整流程，並即時更新旅客狀態。

旅客狀態流程：

```
BOOKED（已訂位） → CHECKED_IN（已報到） → BOARDED（已登機）
```

## 系統功能

| 功能 | 說明 |
|---|---|
| 旅客報到 | 用訂位代號報到，檢查訂位是否存在、是否在報到時間內 |
| 座位分配 | 支援「系統自動配位」和「旅客自選座位」兩種方式 |
| 產生登機證 | 報到成功後產生登機證（座位、登機門、登機時間） |
| 更新狀態 | 登機門掃描登機證，已報到才能登機，否則拒絕 |

## 資料夾結構

```
airport-checkin-system/
├── README.md
├── .gitignore
├── src/
│   ├── Main.java                     # 主程式、示範流程            (E)
│   ├── model/                        # 實體類別
│   │   ├── Person.java               # 抽象類別                    (C)
│   │   ├── Passenger.java            # 旅客，繼承 Person           (C)
│   │   ├── Staff.java                # 工作人員，繼承 Person       (C)
│   │   ├── Flight.java               # 航班                        (C)
│   │   ├── Seat.java                 # 座位                        (C)
│   │   ├── Booking.java              # 訂位                        (C)
│   │   ├── BoardingPass.java         # 登機證                      (E)
│   │   ├── Printable.java            # 介面：可列印                (E)
│   │   ├── PassengerStatus.java      # enum：旅客狀態              (C)
│   │   └── SeatClass.java            # enum：艙等                  (C)
│   └── service/                      # 介面與功能實作
│       ├── CheckInService.java       # 介面：報到                  (D)
│       ├── CounterCheckInService.java# 報到實作                    (D)
│       ├── SeatAllocator.java        # 介面：分配座位              (D)
│       ├── AutoSeatAllocator.java    # 自動配位                    (D)
│       ├── ManualSeatAllocator.java  # 旅客自選                    (D)
│       ├── BoardingService.java      # 介面：登機                  (E)
│       └── GateBoardingService.java  # 登機實作                    (E)
└── docs/
    ├── uml/                          # UML 類別圖                  (B)
    ├── slides/                       # 各組員簡報                  (全員)
    └── report/                       # 書面報告                    (A、F)
```

## 組員分工

| 組員 | 姓名 | 負責工作 |
|---|---|---|
| A | | 組長：需求與功能清單、進度控管、彙整書面報告 |
| B | | 系統設計：類別與介面定義、UML 類別圖 |
| C | | 實體類別：Person、Passenger、Staff、Flight、Seat、Booking、enum |
| D | | 報到與選位：CheckInService、SeatAllocator 及實作 |
| E | | 登機流程：BoardingPass、BoardingService、Main 示範 |
| F | | 文件：簡報模板與合併、書面報告方法章節、貢獻表 |

> 簡報每人做自己上台的那段，依 F 提供的模板製作，12/4 前交給 F 合併。

## 如何執行

需要安裝 JDK 17 以上。在專案根目錄打開 Git Bash：

```bash
# 編譯
javac -encoding UTF-8 -d out src/Main.java src/model/*.java src/service/*.java

# 執行
java -cp out Main
```

用 IntelliJ 或 VS Code 的話，把 `src` 設為 Source Root，直接執行 `Main.java` 即可。

## Git 協作規則

1. **寫之前先 pull**：`git pull`
2. **只改自己負責的檔案**（見上方結構圖括號），要改別人的檔案先在群組講
3. **寫完立刻 push**，不要累積好幾天
4. **commit 訊息寫清楚做了什麼**，例如：
   - ✅ `新增 Seat 類別與 isAvailable 檢查`
   - ❌ `update`、`改了一些東西`
5. push 失敗時，先 `git pull` 再 push

每天的流程：

```bash
git pull
git add .
git commit -m "說明這次改了什麼"
git push
```

## 時程

| 日期 | 工作 |
|---|---|
| 11/17 – 11/23 | 確定類別、介面、UML（B 主導） |
| 11/24 – 11/30 | 寫程式（C 先完成實體類別，D、E 接著做） |
| 12/1 – 12/6 | 製作簡報（12/4 交給 F）、全組排練至少兩次 |
| 12/8 或 12/15 | 上台報告（EC 9032，報告 15 分 + Q&A 3 分） |
| 12/16 – 12/22 | 完成書面報告 |
| **12/23** | **繳交書面報告給助教** |
