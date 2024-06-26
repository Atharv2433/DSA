

class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        // First, sort the intervals based on the starting times
        sort(intervals.begin(), intervals.end());

        // Initialize an empty vector to store the merged intervals
        vector<vector<int>> ans;

        // Iterate through the sorted intervals
        for (int i = 0; i < intervals.size(); i++) {
            // If the answer is empty or the current interval does not overlap with the previous, add it to the answer
            if (ans.empty() || intervals[i][0] > ans.back()[1]) {
                ans.push_back(intervals[i]);
            }
            // If there is an overlap, merge the current interval with the previous one
            else {
                ans.back()[1] = max(ans.back()[1], intervals[i][1]);
            }
        }

        return ans;
    }
};
