let employees = [
{"name":"Arel Khalid","age":25,"active":true,"designation":"Accounting"},
{"name":"Shaylyn Etherton","age":39,"active":false,"designation":"Product Management"},
{"name":"Marjy Ruzek","age":23,"active":true,"designation":"Product Management"},
{"name":"Bailie Edwicker","age":78,"active":false,"designation":"Accounting"},
{"name":"Carrissa Maxted","age":65,"active":true,"designation":"Legal"},
{"name":"Aldwin Gunning","age":52,"active":false,"designation":"Human Resources"},
{"name":"Crosby Keighley","age":21,"active":true,"designation":"Training"},
{"name":"Cinnamon Alldritt","age":51,"active":false,"designation":"Support"},
{"name":"Brendon Bygrave","age":42,"active":false,"designation":"Business Development"},
{"name":"Milli Damiral","age":76,"active":false,"designation":"Accounting"},
{"name":"Barnabe Garm","age":62,"active":false,"designation":"Legal"},
{"name":"Cacilia Eagleton","age":50,"active":true,"designation":"Sales"},
{"name":"Burg Harnell","age":81,"active":false,"designation":"Product Management"},
{"name":"Roseanne Arrow","age":82,"active":true,"designation":"Legal"},
{"name":"Car Hadlington","age":25,"active":false,"designation":"Product Management"},
{"name":"Clarance Darey","age":3,"active":true,"designation":"Legal"},
{"name":"Else Letten","age":1,"active":false,"designation":"Training"},
{"name":"Candy Olivera","age":7,"active":true,"designation":"Human Resources"},
{"name":"Malynda Giddins","age":5,"active":false,"designation":"Support"},
{"name":"Carmelina Goodnow","age":3,"active":true,"designation":"Services"},
{"name":"Sam Bartod","age":5,"active":false,"designation":"Support"},
{"name":"Danila Hansed","age":3,"active":false,"designation":"Training"},
{"name":"Dusty Esilmon","age":3,"active":true,"designation":"Services"},
{"name":"Rhetta Brumwell","age":3,"active":false,"designation":"Services"},
{"name":"Carry McCarrell","age":5,"active":false,"designation":"Sales"},
{"name":"Bennie Greenaway","age":1,"active":false,"designation":"Human Resources"},
{"name":"Rorie Gullyes","age":8,"active":false,"designation":"Services"},
{"name":"Karylin Mughal","age":8,"active":false,"designation":"Services"},
{"name":"Leigh Dollen","age":6,"active":true,"designation":"Engineering"},
{"name":"Trix Le Estut","age":5,"active":false,"designation":"Training"},
{"name":"Meredith Crockett","age":1,"active":false,"designation":"Support"},
{"name":"Faun Cossum","age":6,"active":true,"designation":"Legal"},
{"name":"Barbey Longworthy","age":1,"active":false,"designation":"Engineering"},
{"name":"Sebastiano Le Provest","age":7,"active":true,"designation":"Product Management"},
{"name":"Boothe Camosso","age":5,"active":true,"designation":"Support"},
{"name":"Rodolfo Bottoner","age":8,"active":true,"designation":"Engineering"},
{"name":"Eyde McClune","age":6,"active":true,"designation":"Marketing"},
{"name":"Woodrow Rounsivall","age":7,"active":false,"designation":"Accounting"},
{"name":"Aindrea Egdell","age":2,"active":true,"designation":"Sales"},
{"name":"Alecia Patis","age":3,"active":false,"designation":"Business Development"}
];

console.log(`Total No of Employees: ${employees.length}`)

console.log(`------ Employee Names -------`)
let emp_names = []
/*array iteration */
for(let emp of employees)
{
   let name = emp.name
   emp_names.push(name.toUpperCase())
}
console.log(emp_names)

/*active employees - a normal approach*/
console.log(`---- Active Employees ----`)
for(let employee of employees)
{
  if(employee.active){
      console.log(employee.name.toUpperCase())
  }
}

/*active employees - using filter()*/
let activeCheck = (employee) => {
    return employee.active
}

let activeEmployees = employees.filter(activeCheck)

console.log(`No of Active Employees = ${activeEmployees.length}`)
for(let emp of activeEmployees){
    console.log(emp.name.toUpperCase())
}

/*in-active Employees */
let inActiveCheck = (employee) => (!employee.active)

let inActiveEmployees = employees.filter(inActiveCheck)
console.log(`No of In-Active Employees = ${inActiveEmployees.length}`)

for(let emp of inActiveEmployees){
    console.log(emp.name.toUpperCase())
}

/*Employees whose age < 35 */
let juniorCheck = function(employee){    
    /*
    if(employee.age<35)
      return true;
    else
     return false;  
     */
    return employee.age<35
}

let juniorEmployees = employees.filter(juniorCheck)
console.log(`No of Junior Employees = ${juniorEmployees.length}`)
for(let emp of juniorEmployees){
    console.log(emp.name.toUpperCase())
}


function allEmployees(){
    let result =''
    for(let employee of employees){
        result=result+'<tr><td>'+employee.name+'</td><td>'+employee.age+'</td><td>'+employee.designation+'</td><td align=center>'+employee.active+'</td></tr>'
    }
    document.getElementById('table_body').innerHTML = result;
}


let activeEmployeesFun = ()=>{
    let result = ''
    for(let employee of activeEmployees){
        result=`${result}<tr><td>${employee.name}</td><td>${employee.age}</td><td>${employee.designation}</td><td align=center>${employee.active}</td></tr>`
    }
    displayResult(result); 
}

let inActiveEmployeesFun = () => {
    let result = ''
    for(let employee of inActiveEmployees){
        result=`${result}<tr><td>${employee.name}</td><td>${employee.age}</td><td>${employee.designation}</td><td align=center>${employee.active}</td></tr>`
    }
    displayResult(result); 
}

let juniorStaffFun = ()=>{
    let result = ''
    for(let employee of juniorEmployees){
        result=`${result}<tr><td>${employee.name}</td><td>${employee.age}</td><td>${employee.designation}</td><td align=center>${employee.active}</td></tr>`
    }
    displayResult(result); 
}


let displayResult = (result) =>{
    document.querySelector('#table_body').innerHTML = result   
}