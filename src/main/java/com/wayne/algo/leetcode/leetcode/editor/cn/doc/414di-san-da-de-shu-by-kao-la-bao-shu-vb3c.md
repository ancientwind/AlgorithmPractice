### 解题思路


### 代码

```cpp
class Solution {
public:
    int thirdMax(vector<int>& nums) {
        int n=nums.size();
        if(n<3){
            if(n==2)
            return max(nums[0],nums[1]);
            return nums[0];
        }
        sort(nums.begin(),nums.end(),greater<int>());
        int count=0;
        for(int i=1;i<n;i++){
            if(nums[i]!=nums[i-1]){
                count++;
            }
            if(count==2){
                return nums[i];
            }
        }
        return max(nums[0],nums[n-1]);
    }
};
```