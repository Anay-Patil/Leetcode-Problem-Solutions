class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        ArrayList<int[]> result = new ArrayList<>();
        int i = 0, j = 0;
        while(i < m && j < n) {
            if(nums1[i][0] < nums2[j][0]) {
                result.add(nums1[i]);
                i++;
            }
            else if(nums2[j][0] < nums1[i][0]) {
                result.add(nums2[j]);
                j++;
            }
            else {
                result.add(new int[]{nums1[i][0], nums1[i][1] + nums2[j][1]});
                i++;
                j++;
            }
        }

        while(i < m) {
            result.add(nums1[i]);
            i++;
        }

        while(j < n) {
            result.add(nums2[j]);
            j++;
        }

        int[][] resultArr = new int[result.size()][2];
        for(i = 0; i<result.size(); i++) {
            resultArr[i] = result.get(i);
        }

        return resultArr;
    }
}