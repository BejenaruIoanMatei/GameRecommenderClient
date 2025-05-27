function toggleMethod(method) {
    document.getElementById("nnList").style.display = method === "nn" ? "grid" : "none";
    document.getElementById("cosineList").style.display = method === "cosine" ? "grid" : "none";
}

function validateInput() {
    const input = document.getElementById('gameTitle');
    if (input.value.trim().length < 2) {
        alert('Please enter at least 2 characters.');
        input.focus();
        return false;
    }
    return true;
}
