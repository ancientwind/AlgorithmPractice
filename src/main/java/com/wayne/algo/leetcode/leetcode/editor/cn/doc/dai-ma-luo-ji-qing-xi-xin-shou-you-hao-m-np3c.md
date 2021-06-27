### 解题思路
先利用set集合来去除vector中重复的部分（set默认按照升序进行存放）
判断set元素个数，三个以下的时候，直接利用反向迭代器输出最后一个元素
三个及以上的情况，利用反向迭代器输出第三大的元素。

最后说明，在用迭代器的时候，发现set实际上帮我完成了排序的工作，所以实际的时间复杂度还是O(nlogn)，还是没有达到O(n)的时间复杂度；
### 代码

```cpp
class Solution {
public:
    int thirdMax(vector<int>& nums) {
        set<int> cun(nums.begin(),nums.end());
        int n = cun.size();
        if(n<3){
            return *(cun.rbegin());
        }
        set<int>::reverse_iterator it = cun.rbegin();
        it++;
        it++;
        return *it;
    }
};
```