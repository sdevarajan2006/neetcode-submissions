class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        



        int m = nums1.length;
        int n = nums2.length; 

        int half = (int) Math.ceil((double) (m + n + 1) / 2);

        if ((nums1.length == 0) && (nums2.length == 0)){
            return 0.0;
        }
        if (nums1.length == 0){
            if (nums2.length % 2 == 1){
                return((double)nums2[n / 2]);
            }
            else{
                return(((double) nums2[n/2] + nums2[(n/2) -1]) / 2) ;
            }
        }
        if (nums2.length == 0){
            if (nums1.length % 2 == 1){
                return((double)nums1[m / 2]);
            }
            else{
                return(((double) nums1[m/2] + nums1[(m/2) -1 ]) / 2) ;
            }
        }


        

        int left = 0; 
        int right = half; 

        int partition = -1;

        while(left <= right){
            int mid = (left + right) / 2; // amt from nums1
            int n2 = half - mid;

            int n1maxLeft; 
            int n1minRight;
            int n2maxLeft;
            int n2minRight;

            if(mid == 0){
                n1maxLeft = Integer.MIN_VALUE;
                n1minRight = nums1[0];
            }
            else{
                n1maxLeft = nums1[mid - 1];
                if (mid == nums1.length){
                    n1minRight = Integer.MAX_VALUE;
                }
                else{
                    n1minRight = nums1[mid];
                }
                
            }

            if(n2 == 0){
                n2maxLeft = Integer.MIN_VALUE;
                n2minRight = nums2[0];
            }
            else{
                n2maxLeft = nums2[n2 - 1];

                if (n2 == nums2.length){
                    n2minRight = Integer.MAX_VALUE;
                }
                else{
                    n2minRight = nums2[n2];
                }
    
            }


            // check if valid 
            
            if (n1maxLeft > n2minRight){
                right = mid - 1;
            }
            else if (n2maxLeft > n1minRight){
                left = mid + 1;

            }
            else{
                

                if ((m + n) % 2 == 1){
                    
                    if (n1maxLeft > n2maxLeft){
                        return(n1maxLeft);
                    }
                    else{
                        return(n2maxLeft);
                    }

                }
                else{
                    
                    int sum = 0;
                    if (n1maxLeft > n2maxLeft){
                        sum += n1maxLeft;
                        if(mid - 2>= 0){
                            if(nums1[mid -2] > n2maxLeft){
                                sum += nums1[mid -2];
                            }
                            else{
                                sum += n2maxLeft;

                            }
                        }
                        else{
                            sum += n2maxLeft;
                        }
                        System.out.println(sum);
                    }
                    else{
                        sum += n2maxLeft;
                        if (n2 - 2 >= 0){
                            if(nums2[n2 - 2] > n1maxLeft){
                                sum += nums2[n2 - 2];
                            }
                            else{
                                sum += n1maxLeft;

                            }
                        }
                        else{
                            sum += n1maxLeft;
                        }
                    }
                    return((double) sum/2);
                }
                
            }

            

        


        }
        return(-1);
    }
}
