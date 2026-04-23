function converter() {
    let valor = document.getElementById("valor").value;
    let moeda = document.getElementById("moeda").value;

    fetch(`http://localhost:8080/api/converter?valor=${valor}&moeda=${moeda}`)
        .then(res => res.json())
        .then(data => {
            document.getElementById("resultado").innerText =
    `R$ ${data.valor_original} → ${data.resultado} (${data.moeda})`;
        })
        .catch(err => {
            console.error(err);
            alert("Erro ao conectar com o backend");
        });
    }