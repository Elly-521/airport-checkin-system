# ✈️ Airport Check-in & Boarding System

OOP 課程期末分組專題：機場報到與登機系統

## 專案簡介

本系統管理旅客從**訂位 → 報到 → 劃位 → 託運行李 → 產生登機證 → 登機**的完整流程，並即時更新旅客狀態。

旅客狀態流程：

```
BOOKED（已訂位） → CHECKED_IN（已報到） → BOARDED（已登機）
```

## 系統功能

| 功能 | 說明 | 負責 |
|---|---|---|
| 航班管理 | 新增、查詢、修改登機門、延誤 | 成員2 |
| 旅客與訂位 | 建立旅客與訂位、狀態轉換 | 成員3 |
| 座位 | 經濟艙／商務艙座位、劃位、座位表 | 成員4 |
| 報到與行李 | 櫃台報到／線上報到、報到時間檢查、艙等檢查、行李超重費 | 成員5 |
| 登機證與登機 | 產生並列印登機證、登機順序、登機 | 成員6 |
| 主選單 | 整合所有功能 | 成員1 |

### 加強功能

| 負責 | 加強項目 |
|---|---|
| 成員1 | 航班報到統計報表（未報到／已報到／已登機人數） |
| 成員2 | CSV 讀寫航班資料、航班取消 |
| 成員3 | 新增／取消訂位 |
| 成員4 | 新增 PremiumEconomySeat（豪華經濟艙） |
| 成員5 | 單件超過 32kg 拒收 |
| 成員6 | 登機截止判斷、未登機名單 |

## 組員分工

| 成員 | 姓名 | 負責模組 | 負責檔案 | 報告工作 |
|---|---|---|---|---|
| 成員1 | | 組長／系統整合 | `AirportSystem.java` | Git、進度管理、整合測試與截圖報告 |
| 成員2 | | 航班 | `Flight.java` | UML 類別圖 |
| 成員3 | | 旅客與訂位 | `Passenger.java`、`PassengerStatus.java`、`Booking.java` | 需求說明 |
| 成員4 | | 座位 | `Seat.java`、`EconomySeat.java`、`BusinessSeat.java`、`SeatClass.java` | 多型展示、OOP 概念說明 |
| 成員5 | | 報到與行李 | `CheckInService.java`、`CounterCheckInService.java`、`OnlineCheckInService.java`、`Baggage.java`、`CheckInException.java` | 報到相關測試案例 |
| 成員6 | | 登機證與登機 | `BoardingPass.java`、`Printable.java`、`BoardingService.java` | 簡報模板與合併 |

> 每人為自己的模組寫 2～3 個測試情況（含錯誤情況），交給成員1 統一執行並整理。
> 簡報每人做自己模組的部分（負責的類別、用到的 OOP 概念、執行畫面），依成員6 的模板製作。

## 資料夾結構

```
airport-checkin-system/
├── README.md
├── .gitignore
├── src/
│   ├── AirportSystem.java          # 主程式、主選單              成員1
│   ├── model/
│   │   ├── Flight.java             # 航班                        成員2
│   │   ├── Passenger.java          # 旅客                        成員3
│   │   ├── PassengerStatus.java    # enum：旅客狀態              成員3
│   │   ├── Booking.java            # 訂位                        成員3
│   │   ├── Seat.java               # 抽象類別：座位              成員4
│   │   ├── EconomySeat.java        # 經濟艙座位，繼承 Seat       成員4
│   │   ├── BusinessSeat.java       # 商務艙座位，繼承 Seat       成員4
│   │   ├── SeatClass.java          # enum：艙等                  成員4
│   │   ├── Baggage.java            # 行李，實作 Printable        成員5
│   │   ├── BoardingPass.java       # 登機證                      成員6
│   │   └── Printable.java          # 介面：可列印                成員6
│   └── service/
│       ├── CheckInService.java     # 介面：報到、行李託運        成員5
│       ├── CounterCheckInService.java # 櫃台報到（45 分截止）   成員5
│       ├── OnlineCheckInService.java  # 線上報到（60 分截止）   成員5
│       ├── CheckInException.java   # 報到失敗的例外              成員5
│       └── BoardingService.java    # 登機、登機順序              成員6
└── docs/
    ├── uml/                        # UML 類別圖                  成員2
    ├── test/                       # 測試情況與執行截圖          成員1
    ├── slides/                     # 簡報                        全員
    └── report/                     # 書面報告                    成員1
```

### 類別之間的相依關係

```
成員2 Flight ─┐
成員3 Passenger、Booking ─┼─▶ 成員5 CheckInService（介面） ─▶ 成員6 BoardingService ─▶ 成員1 AirportSystem
成員4 Seat ───┘
```

成員5 需要成員2～4 的類別，成員6 需要成員2～5 的類別，所以**成員2～4 請先完成並 push**。

## OOP 概念對照

| 概念 | 用在哪裡 |
|---|---|
| 封裝 | Passenger 的狀態只能透過 `checkIn()`、`board()` 修改 |
| 繼承 | EconomySeat、BusinessSeat 繼承 Seat |
| 抽象 | Seat 是抽象類別，不能直接 new |
| 多型 | 不同座位的 `getFreeBaggageKg()` 回傳不同免費行李額度；主選單用同一個 `doCheckIn()` 處理櫃台和線上報到 |
| 介面 | CheckInService 有櫃台、線上兩種實作；BoardingPass 和 Baggage 都實作 Printable |
| 例外處理 | 報到失敗丟出 CheckInException |

### 設計理由（Q&A 用）

- **為什麼 CheckInService 是介面？** 現實中有櫃台和線上兩種報到方式，規則不同（截止時間、能不能託運），但對主選單來說操作一樣。用介面之後，主選單不用寫 if-else 判斷是哪一種，之後要新增「自助報到機」也只要多寫一個類別。
- **為什麼 Seat 是抽象類別？** 每個座位一定屬於某個艙等，不會有「沒有艙等的座位」，所以不能直接 new Seat。不同艙等的免費行李額度由子類別決定。
- **為什麼 Printable 是介面？** 登機證和行李條是完全不同的東西，沒有共同的父類別，但都需要「列印」這個能力，所以用介面而不是繼承。

## 如何執行

需要安裝 JDK 17 以上。在專案根目錄打開 Git Bash：

```bash
# 編譯
javac -encoding UTF-8 -d out src/*.java src/model/*.java src/service/*.java

# 執行
java -cp out AirportSystem
```

用 IntelliJ 或 VS Code 的話，把 `src` 設為 Source Root，直接執行 `AirportSystem.java` 即可。

## Git 協作規則

1. **寫之前先 pull**：`git pull`
2. **只改自己負責的檔案**（見上方分工表），要改別人的檔案先在群組講
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
| 11/17 – 11/23 | 開會確認類別與方法規格、每人在自己電腦編譯執行骨架 |
| 11/24 – 11/30 | 基本功能（成員2～4 先完成，成員5、6 接著做） |
| 12/1 – 12/6 | 加強功能、測試情況、主選單整合、各自做簡報 |
| 12/8 或 12/15 | 上台報告（EC 9032，報告 15 分 + Q&A 3 分） |
| 12/16 – 12/22 | 整合測試報告、完成書面報告 |
| **12/23** | **繳交程式與報告給助教** |
