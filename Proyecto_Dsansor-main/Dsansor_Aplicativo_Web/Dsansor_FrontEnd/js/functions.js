

function getInfo(){
    fetch('https://631fd14fe3bdd81d8eedf209.mockapi.io/Proyecto_vostro')
.then(response => response.json())
.then(data => CreateTableFromJSON(data));
//.then(data => console.log(data));
}



function CreateTableFromJSON(data){




  // Extract value from table header. 
  // ('Book ID', 'Book Name', 'Category' and 'Price')
  let col = [];
  for (let i = 0; i < data.length; i++) {
    for (let key in data[i]) {
      if (col.indexOf(key) === -1) {
        col.push(key);
      }
    }
  }

  // Create table.
  const table = document.createElement("table");

  // Create table header row using the extracted headers above.
  let tr = table.insertRow(-1);                   // table row.

  for (let i = 0; i < col.length; i++) {
    let th = document.createElement("th");      // table header.
  th.innerHTML = col[i];
  tr.appendChild(th);
  }

  // add json data to the table as rows.
  for (let i = 0; i < data.length; i++) {

  tr = table.insertRow(-1);

  for (let j = 0; j < col.length; j++) {
      let tabCell = tr.insertCell(-1);
      tabCell.innerHTML = data[i][col[j]];
  }
  }

  // Now, add the newly created table with json data, to a container.
  const divShowData = document.getElementById('showData');
  divShowData.innerHTML = "";
  divShowData.appendChild(table);
}
