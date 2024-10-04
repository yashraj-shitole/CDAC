function Add(x, y)
{
    return x+y;
}
function Sub(x, y)
{
    return x-y;
}
function Mult(x, y)
{
    return x*y;
}

module.exports = {Add, Sub}
// is same as
// module.exports = {Add : Add, Sub : Sub}