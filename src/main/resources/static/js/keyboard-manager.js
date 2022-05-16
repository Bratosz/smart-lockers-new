let backSlash = 191;
let ctrl = 17;
let enter = 13;

function loadGeneralKeyBehaviour() {
    ctrlIsPressed();
}

function loadNavKeysBehaviour() {
    pressedCtrlBackSlashGoToSearchWindow();
    enterKeyBehaviour();
}

function pressedCtrlBackSlashGoToSearchWindow() {
    ifKeyClickedWithCtrlAtThenGoTo(
        backSlash,
        $(document),
        '#nav-input-last-name');
}

function enterKeyBehaviour() {
    ifKeyClickedAtThenDo(enter, $('#nav-input-last-name'), function () {
        $('#nav-button-search-by-last-name').trigger('click');
    });
}

function ifKeyClickedWithCtrlAtThenGoTo(keyCode, $clickedArea, elementToFocus) {
    $clickedArea.keydown(function (e) {
        if(e.keyCode == keyCode && ctrlPressed) {
            $(elementToFocus).focus();
        }
    });
}

function ifKeyClickedAtThenDo(keyCode, $where, desiredAction) {
    $where.keydown(function (e) {
        if(e.keyCode == keyCode && !ctrlPressed) {
            e.preventDefault();
            desiredAction();
        }
    });
}

function ctrlIsPressed() {
    $(document).keydown(function (e) {
        if(e.ctrlKey) ctrlPressed = true;
    }).keyup(function(e) {
        if(e.keyCode == ctrl) {
            ctrlPressed = false;
        }
    })
}