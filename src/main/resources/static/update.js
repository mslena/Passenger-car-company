function toggleForm() {
    var dataType = document.getElementById('dataType').value;
    var busForm = document.getElementById('busForm');
    var routeForm = document.getElementById('routeForm');
    busForm.classList.remove('hidden');
    if (dataType === 'bus') {
        busForm.classList.remove('hidden');
        routeForm.classList.add('hidden');
    } else if (dataType === 'route') {
        busForm.classList.add('hidden');
        routeForm.classList.remove('hidden');
    }
}


