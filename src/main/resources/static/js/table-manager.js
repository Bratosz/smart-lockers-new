function getRowTemplate($table) {
    return $table.find("tr:nth-child(1)");
}

function removeTableRows($table) {
    $table.find("tr:not(tr:nth-child(1))").remove();
    return $table;
}

function writeDataToTable(elements, $table, writingMethod) {
    show($table);
    $table = removeTableRows($table);
    for (let e of elements) {
        addStdRowToTable(e, $table, writingMethod);
    }
    return $table;
}

function getCheckedBarcodes($tableBody) {
    let barcodes = [];
    $tableBody.find('input[type="checkbox"]:checked')
        .each(function () {
            let clothBarcode = parseInt($(this).closest('tr').find('.cell-barcode').text());
            barcodes.push(clothBarcode);
        });
    return barcodes;
}

function addStdRowToTable(element, $table, writingMethod) {
    let $tbody = $table.find('tbody');
    let $row = getRowTemplate($tbody).clone();
    $row.removeAttr('id');
    $row.css('display', 'table-row');
    $row = writingMethod(element, $row);
    $tbody.append($row);
}

function addLabeledRowToTable(label, content, $table, writingMethod) {
    let $row = getRowTemplate($table).clone();
    $row.removeAttr('id');
    $row.css('display', 'table-row');
    $row = writingMethod(label, content, $row);
    $table.append($row);
}

function addRowToTable($table) {
    let $row = getRowTemplate($table).clone();
    $row.removeAttr('id');
    $row.css('display', 'table-row');
    $table.append($row);
}

function refreshRow(element, $row, writingMethod) {
    writingMethod(element, $row);
}

function writeLockersWithSortingToTable(lockers, $table, writingMethod) {
    writeDataToTable(
        sort(lockers,
            'plant.plantNumber',
            'lockerNumber'),
        $table,
        writingMethod);
}



function writeEmployeesWithSortingToTable(employees, $table, writingMethod) {
    writeDataToTable(
        sort(employees,
            'box.locker.plant.plantNumber',
            'box.locker.lockerNumber',
            'box.boxNumber'),
        $table,
        writingMethod);
}

function clearAndHideTable($table) {
    removeTableRows($table);
    $table.css('display', 'none');
}

function exposeTable($table) {
    $table.css('display', 'table');
}