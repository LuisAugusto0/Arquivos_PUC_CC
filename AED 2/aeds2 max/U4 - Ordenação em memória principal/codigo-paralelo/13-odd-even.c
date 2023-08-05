void oddEvenSort(int a[], int size){
   for(int i = 0; i < size; i++) {
      if(i%2 == 1)
         for(int j = 1; j < size-1; j += 2){
            if(a[j] > a[j+1]){
               swap(j, j+1);
            }
         }
      else
         for(int j = 0; j < size-1; j += 2){
            if(a[j] > a[j+1]){
               swap(j, j+1);
            }
         }
   }	
}


