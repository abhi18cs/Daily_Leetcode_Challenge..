/**
 * @param {any[]} arr
 * @param {number} depth
 * @return {any[]}
 */
var Flat=function(arr,depth,n){
         if(depth==n)
         {
            return arr;
         }
         let Arr=[];
         let i=0;
         while(i<arr.length)
         {
               if(Number.isInteger(arr[i]))
               { 
                  Arr.push(arr[i]);
               }
               else
               {
                  const v=Flat(arr[i],depth+1,n);  
                  v.forEach((x)=>{
                      Arr.push(x);
                  });
               }
               i+=1;  
         }
         return Arr;
}
var flat = function (arr, n) {
           return Flat(arr,0,n);
};