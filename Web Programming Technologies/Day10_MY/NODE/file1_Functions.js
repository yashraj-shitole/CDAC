

//calculate funtion cal({object of numbers},type:"add","sub","mul","div")
function cal(nums,type){


//uses type to perform specific operation and use switch case to call that function
    switch(type){
        case "add":{
            //return the sum of all numbers in the object
            return add(nums)
            //as directly return is used so break is not required as it is unreachable
        }
        case "sub":{
            return sub(nums)
        }

        case "mul":{
            return mul(nums)
        }

        case "div":{
            return div( nums)
        }

        default:{
            console.log("Invalid type")
            //returns null if  type is not found
            return null;
        }


    }
}

function add(nums){
    let result=0
    // add all numbers in the array object by iterating them using for loop
    for(var i=0;i<nums.length;i++){
        result+=nums[i];
    }

    return result

}

function sub(nums){
    //storing first element of array object
    //let is used as result is required for local scope
    let result=nums[0]
    for(var i=1;i<nums.length;i++){
        result-=nums[i];
    }
    //returns the result
    return result

}

function mul(nums){

    let result=1
    for(var i=0;i<nums.length;i++){
        result *=nums[i];
    }
    return result
}

function div(nums=[1]){
    let result=nums[0]
    for(var i=1;i<nums.length;i++){
        //if statement so that if array object contains 0 the division by zero error is avoided
        if(nums[i]!=0){
            result/=nums[i];
        }
    }

    return result
}

//exporting multiple functions
module.exports={cal,add,sub,mul,div}