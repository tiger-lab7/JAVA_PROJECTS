import java.util.stream.IntStream;

public class Main {

    public static void main(String... args) {
        //Solution solution = new Solution();
        //DPSolution solution = new DPSolution();
        GreedySolution solution = new GreedySolution();

        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(solution.jump(nums));

        int[] nums1 = {2, 3, 0, 1, 4};
        System.out.println(solution.jump(nums1));

        int[] nums2 = {2, 3, 5, 0, 1, 4, 1 ,1, 2, 1, 0};
       System.out.println(solution.jump(nums2));

        int[] nums3 = {1, 2};
        System.out.println(solution.jump(nums3));

        int[] nums4 = {0};
        System.out.println(solution.jump(nums4));

        int[] nums5 = {5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5};
        System.out.println(solution.jump(nums5));

        int[] nums6 = IntStream.iterate(2, (x) -> 2).limit(30).toArray();
       System.out.println(solution.jump(nums6));

        int[] nums7 = {5,8,1,8,9,8,7,1,7,5,8,6,5,4,7,3,9,9,0,6,6,3,4,8,0,5,8,9,5,3,7,2,1,8,2,3,
                8,9,4,7,6,2,5,2,8,2,7,9,3,7,6,9,2,0,8,2,7,8,4,4,1,1,6,4,1,0,7,2,0,3,9,8,7,7,0,6,9,
                9,7,3,6,3,4,8,6,4,3,3,2,7,8,5,8,6,0};
        System.out.println("nums7 " + solution.jump(nums7));


    }
}



//SolutionMultithreading solutionM = new SolutionMultithreading();

//System.out.println(solutionM.jump(nums2));