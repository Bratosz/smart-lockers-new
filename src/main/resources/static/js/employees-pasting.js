let rowsInTable = 0;
loadTable();

$(document).ready(function () {
    $('input').on('paste', function (e) {
        let $this = $(this);
        console.log(e);
        $.each(e.originalEvent.clipboardData.items, function (index, value) {
            if (value.type === 'text/plain') {
                value.getAsString(function (text) {
                    let x = $this.closest('td').index();
                    let y = $this.closest('tr').index() + 1;
                    text = text.trim('\r\n');
                    console.log(text.split('\n'));
                    $.each(text.split('\n'), function (i2, v2) {
                        $.each(v2.split('\t'), function (i3, v3) {
                            let cellNameValue = v3.trim().toUpperCase();
                            // if (isItHeaderRow(cellNameValue)) {
                            //     y -= 1;
                            //     return false;
                            // }
                            let row = y + i2;
                            if(rowsAreFilled(row)) {
                                extendTable($('#table-for-employees-paste'));
                            }
                            let col = x + i3;
                            $this.closest('table').find('tr:eq(' + row + ') td:eq(' + col + ') input').val(v3);
                        });

                    });
                });
            }
        });
        return false;
    });
});

function rowsAreFilled(actualRowNumber) {
    if(rowsInTable == (actualRowNumber - 1)) {
        return true;
    } else {
        return false;
    }
}

function loadTable() {
    let $table = ($('#table-for-employees-paste'));
    removeTableRows($table);
    for(let i = 0; i < 10; i++) {
        extendTable($table);
    }
}

function extendTable($table) {
    addEmptyRowToTable($table);
    rowsInTable++;
}