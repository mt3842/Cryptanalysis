document.addEventListener("DOMContentLoaded", function() {
    const encodeButton = document.getElementById("encode-button");
    const decodeButton = document.getElementById("decode-button");

    encodeButton.addEventListener("click", function() {
        const textToChange = document.getElementById("textToChange").value;
        const firstKeyword = document.getElementById("firstKeyword").value;
        const secondKeyword = document.getElementById("secondKeyword").value;

        console.log("Encode button clicked!"); // Add this line
        fetch("/encode", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                textToChange: textToChange,
                firstKeyword: firstKeyword,
                secondKeyword: secondKeyword
            })
        })
        .then(response => response.json())
        .then(data => {
            document.getElementById("output").innerHTML = data.output;
        })
        .catch(error => console.error("Error:", error));
    });

    decodeButton.addEventListener("click", function() {
        const textToChange = document.getElementById("textToChange").value;
        const firstKeyword = document.getElementById("firstKeyword").value;
        const secondKeyword = document.getElementById("secondKeyword").value;

        fetch("/decode", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                textToChange: textToChange,
                firstKeyword: firstKeyword,
                secondKeyword: secondKeyword
            })
        })
        .then(response => response.json())
        .then(data => {
            document.getElementById("output").innerHTML = data.output;
        })
        .catch(error => console.error("Error:", error));
    });
});