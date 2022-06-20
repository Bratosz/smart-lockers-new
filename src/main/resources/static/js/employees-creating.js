loadEmployeesToCreate();
loadDepartments($('#select-department'));
loadLocations($('#select-location'));
loadPositionsByDepartment();

$('#select-department').change(function () {
    loadPositionsByDepartment();
});

$('#button-post-employees-to-create').click(function () {
    let employeesToCreate = [];
    getCheckedRows($('#table-of-employees-to-create')).forEach(
        r => {
            let etc = {
                employeeId: r.attr('id'),
                departmentId: r.find('.select-department').val(),
                positionId: r.find('.select-position').val(),
                locationId: r.find('.select-location').val()
            };
            employeesToCreate.push(etc);
        }
    )
    $.ajax({
        url: postCreateEmployees(),
        method: 'post',
        contentType: 'application/json',
        data: JSON.stringify(employeesToCreate),
        success: function (response) {
            alert(response.message);
        }
    }).done(function () {
        loadEmployeesToCreate();
    });
});

$('#button-select-all-rows').click(function () {
    $('#table-of-employees-to-create').find('input[type="checkbox"]').each(function () {
        $(this).prop('checked', true);
    });
});

$('#button-unselect-all-rows').click(function () {
    $('#table-of-employees-to-create').find('input[type="checkbox"]').each(function () {
        $(this).prop('checked', false);
    });
});

$('#button-set-dep-pos-loc').click(function () {
    let departmentId = $('#select-department').val(),
        positionId = $('#select-position').val(),
        locationId = $('#select-location').val(),
        employeesIds = [];
    getCheckedRows($('#table-of-employees-to-create')).forEach(
        r => {
            let employeeId = r.attr('id');
            employeesIds.push(employeeId);
        });
    $.ajax({
        url: postSetDepartmentPositionLocationForEmployeesToCreate(
            departmentId, positionId, locationId),
        method: 'post',
        contentType: 'application/json',
        data: JSON.stringify(employeesIds),
        success: function (response) {
            if (!response.succeed) alert("Coś poszło nie tak");
        }
    }).done(function () {
        loadEmployeesToCreate();
    })

});


function loadEmployeesToCreate() {
    $.ajax({
        url: getEmployeesToCreate(),
        method: 'get',
        success: function (response) {
            if (response.succeed) {
                displayEmployeesToCreate(response.entity);
            }
        }
    })
}

function displayEmployeesToCreate(employeesToCreate) {
    writeDataToTable(
        sort(employeesToCreate, "gender"),
        $('#table-of-employees-to-create'),
        writeEmployeeToCreateToRow
    );
    console.log(employeesToCreate);
}

function loadSelectInRowForEmployeeToCreate($select, options, actual, placeholder) {
    if (actual.surrogate) {
        appendOptionsToSelect(options, $select, placeholder);
    } else {
        appendOptionsToSelectAndSelectActual(
            sort(options, "name"),
            $select,
            actual);
    }
    $select.find('option').each(function () {
        $(this).attr('disabled', 'disabled');
    })

}

