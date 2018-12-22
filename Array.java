

public class Array {



    public int span(int [] nums){

        final int MAX_VALUE = 9;

        int span;
        int [] spanArray = new int [MAX_VALUE];
        int [] spanIndexArray = new int [nums.length];

        int [] counter = new int[MAX_VALUE];

        int [] multiOccurrence;

        if(nums.length == 1 || (nums.length == 2 && nums[0] != nums[1])){
            return 1;
        }else if (nums.length == 0){
            return 0;
        }

        for (int i = 0; i < nums.length; i++) { counter[nums[i] - 1]++; }

        multiOccurrence = getMulti(counter);



        for(int i = 0; i < multiOccurrence.length; i++){
            int minIndex;
            int maxIndex;
            int spanIndex = 0;
            flushArr(spanIndexArray);

            if (multiOccurrence[i] > 0){
                for(int j = 0; j < nums.length; j++){
                    if(nums[j] == multiOccurrence[i]){
                        spanIndexArray[j] = j;
                    }else{
                        spanIndexArray[j] = -1;
                    }
                }


                maxIndex = findMaxSpan(spanIndexArray);
                minIndex = findMinSpan(spanIndexArray);


                for(int k = minIndex; k < maxIndex + 1; k++){
                    spanIndex++;
                }

                spanArray[i] = spanIndex;
            }
        }

        span = findMaxSpan(spanArray);
        return span;
    }




    private int [] getMulti(int [] counter){
        int [] multiOccurrence = new int [counter.length];
        for(int i = 0; i < counter.length; i++){

            if(counter[i] > 1){
                multiOccurrence[i] = i + 1;
            }

        }

        return multiOccurrence;
    }

    private int findMaxSpan(int [] spanArr){

        int max = spanArr [0];

        for(int i = 1; i < spanArr.length; i++){
            if(spanArr[i] > max && spanArr[i] != -1){
                max = spanArr[i];
            }

        }

        return max;
    }

    private int findMinSpan(int [] spanArr){

        int min = 0;

        for(int i = 0; i < spanArr.length; i++){
            if(spanArr[i] != -1){
                min = spanArr[i];
            }
        }

        for(int i = 0; i < spanArr.length; i++){

            if(spanArr[i] < min && spanArr[i] != -1){
                min = spanArr[i];
            }

        }

        return min;
    }

    private void flushArr(int [] arr){
        for (int i = 0; i < arr.length; i++){
            arr[i] = 0;
        }
    }
}
