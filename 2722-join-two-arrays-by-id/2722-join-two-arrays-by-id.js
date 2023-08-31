/**
 * @param {Array} arr1
 * @param {Array} arr2
 * @return {Array}
 */
var join = function(arr1, arr2) {
    const joined = {};

    arr1.forEach(item => joined[item.id] = item)
    
    arr2.forEach(item => {
        if (joined[item.id]) {
            joined[item.id] = Object.assign(joined[item.id], item)
        } else {
            joined[item.id] = item;
        }
    })
    return Object.values(joined);
};