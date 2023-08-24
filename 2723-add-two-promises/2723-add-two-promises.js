//Approach-1 
// Use Promise.all() method along with await to wait for both promises to resolve. Once they resolve, their values are retrieved and stored in the variables value1 and value2. Finally, a new promise is returned with the sum of value1 and value2.
// var addTwoPromises = async function(promise1, promise2) {
//   // Wait for both promises to resolve and retrieve their values
//   const [value1, value2] = await Promise.all([promise1, promise2]);

//   // Return a new promise that resolves with the sum of the values
//   return value1 + value2;
// };


//Approach-2
var addTwoPromises = async function(promise1, promise2) {
    return Promise.all([promise1,promise2])
        .then(value=>value.reduce((acc,val)=>acc+val,0))    
};
/**
 * addTwoPromises(Promise.resolve(2), Promise.resolve(2))
 *   .then(console.log); // 4
 */