$(document).ready(function() {
    $(".country-section").each(function() {
        var thead = $(this).find("thead");
        var tbody = $(this).find("tbody");

        tbody.hide();
        thead.click(function() {
            tbody.slideToggle();
        });
    });
});