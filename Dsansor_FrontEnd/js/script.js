
const form = document.getElementById("transactionForm");
form.addEventListener ("submit", function(event){
    event.preventDefault();
    let transactionFormData = new FormData(form);
    let transactionTableRef = document.getElementById("transactionTable");
    let newTransactionRowRef = transactionTableRef.insertRow(-1);

    let newTypeCellRef = newTransactionRowRef.insertCell(0);
    newTypeCellRef.textContent= transactionFormData.get("transactionOrden")

    newTypeCellRef = newTransactionRowRef.insertCell(1);
    newTypeCellRef.textContent= transactionFormData.get("transactionAsignacion")

    newTypeCellRef = newTransactionRowRef.insertCell(2);
    newTypeCellRef.textContent=  transactionFormData.get("transactionActividad")

    newTypeCellRef = newTransactionRowRef.insertCell(3);
    newTypeCellRef.textContent= transactionFormData.get("transactionSitio")

    newTypeCellRef = newTransactionRowRef.insertCell(4);
    newTypeCellRef.textContent= transactionFormData.get("transactionValor")

    newTypeCellRef = newTransactionRowRef.insertCell(5);
    newTypeCellRef.textContent= transactionFormData.get("transactionInstalacion")

    newTypeCellRef = newTransactionRowRef.insertCell(6);
    newTypeCellRef.textContent= transactionFormData.get("transactionIntegracion")

    newTypeCellRef = newTransactionRowRef.insertCell(6);
    newTypeCellRef.textContent= transactionFormData.get("transactionDocumentacion")
})

