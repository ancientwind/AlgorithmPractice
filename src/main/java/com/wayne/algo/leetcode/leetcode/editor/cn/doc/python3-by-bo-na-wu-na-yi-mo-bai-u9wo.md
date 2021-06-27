### 解题思路


### 代码

```python3
class Solution:
    def thirdMax(self, nums: List[int]) -> int:
        set_nums=list(set(nums))
        set_nums.sort()
        return set_nums[-1] if len(set_nums)<3 else set_nums[-3]
```