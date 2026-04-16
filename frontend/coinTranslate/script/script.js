function converter() {
    let valor = document.getElementById("valor").value;
    let moeda = document.getElementById("moeda").value;

    fetch(`http://localhost:8080/api/converter?valor=${valor}&moeda=${moeda}`)
        .then(res => res.text())
        .then(data => {
            document.getElementById("resultado").innerText =
                "Resultado: " + data;
        });
}