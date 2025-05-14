List<List<int>> getTransformationMatrix(List<int> nums) {
  List<List<int>> T = List.generate(26, (_) => List.filled(26, 0));
  for (int i = 0; i < nums.length; i++) {
    for (int step = 1; step <= nums[i]; step++) {
      T[i][(i + step) % 26]++;
    }
  }
  return T;
}