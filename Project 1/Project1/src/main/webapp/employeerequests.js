


function getRequests(){

    let url = "http://localhost:8080/Project1/reimform";

//1.Create our XHR Object
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if(xhr.readyState == 4 && xhr.status == 200){
            let resp = JSON.parse(xhr.responseText);

            console.log(resp);
            
            populateReim(resp);
        }
    }



xhr.open('GET', url, true);

xhr.send();
}

function populateReim(res){
    let reimDiv = document.getElementById('reims');

    let reimTable = document.createElement('table');
    reimTable.setAttribute('class', 'table')

    let tHead = document.createElement('thead');

    let tableHeaderrow = document.createElement('ts');

    let tHeaders = ['id', 'status', 'author[id]', 'amount'];
   //  for(let h of tHeaders){
   //      let th = document.createElement('th');
   //      th.setAttribute('scope', 'col');
   //      th.innerHTML = h;
   //      tableHeaderrow.append(th);
   //  }
    tHead.append(tableHeaderrow)
    reimTable.append(tHead);

    for(let reimbursements of res){
       let tr = document.createElement('tr');

       let tdID = document.createElement('td');
       tdID.innerHTML = reimbursements.id;
       tr.append(tdID);

       let tdStatus = document.createElement('td');
       tdStatus.innerHTML = reimbursements.status;
       tr.append(tdStatus);

       let tdAuthor = document.createElement('td');
       tdAuthor.innerHTML = reimbursements.author.id;
       tr.append(tdAuthor);
       
       let tdAmount = document.createElement('td');
       tdAmount.innerHTML = reimbursements.amount;
       tr.append(tdAmount);

       let tdCert = document.createElement('td');
       tdCert.innerHTML = reimbursements.certificationtype;
       tr.append(tdCert);

       let tdLocation = document.createElement('td');
       tdLocation.innerHTML = reimbursements.location;
       tr.append(tdLocation);

       let tdDate = document.createElement('td');
       tdDate.innerHTML = reimbursements.date;
       tr.append(tdDate);


       

       reimTable.append(tr);

    }
    reimDiv.append(reimTable);



}