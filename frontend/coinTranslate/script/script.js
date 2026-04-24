function converter() {
    let valor = document.getElementById("valor").value;
    let origem = document.getElementById("origem").value;
    let destino = document.getElementById("destino").value;

    fetch(`http://localhost:8080/api/converter?valor=${valor}&origem=${origem}&destino=${destino}`)
        .then(res => res.json())
        .then(data => {
            document.getElementById("resultado").innerText =
                `${data.valor_original} (${data.origem}) → ${data.resultado} (${data.destino})`;
        });
}