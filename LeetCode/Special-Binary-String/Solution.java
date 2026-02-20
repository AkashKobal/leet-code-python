Input: s = "11011000"

Find balanced chunks (count = 0 points):
  1 1 0 1 1 0 0 0
  ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓
  1 2 1 2 3 2 1 0 ← count values
              ↑
            count=0 → found chunk "11011000"

Since it's one chunk, extract inner: "1011000"

Recursively process "1011000":
  1 0 1 1 0 0 0
  ↓ ↓ ↓ ↓ ↓ ↓ ↓
  1 0 1 2 1 0 ← count values
    ↑       ↑
  Chunks: "10" and "11000"

Process "10": inner="" → ""
  Result: "1" + "" + "0" = "10"

Process "11000": inner="100"
  Recursively on "100":
    1 0 0
    ↓ ↓ ↓
    1 0 ← found "100"
    Inner: "0" → base case → "0"
    Result: "1" + "0" + "0" = "100"
  Result: "1" + "100" + "0" = "11000"

Chunks: ["10", "11000"]
Sort descending: ["11000", "10"]
Join: "1100010"

Final wrap: "1" + "1100010" + "0" = "111000100"