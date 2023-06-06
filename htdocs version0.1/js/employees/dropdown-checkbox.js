$(document).ready(function() {
  $('#basic').multiselect({
      templates: {
          li: '<li><div class="checkbox"><label></label></div></li>'
      }
  });
  $('.multiselect-container div.checkbox').each(function (index) {

    var id = 'multiselect' + index,
    $input = $(this).find('input');

    // Associate the label and the input
    $(this).find('label').attr('for', id);
    $input.attr('id', id);


    $(this).click(function (e) {
        // Prevents the click from bubbling up and hiding the dropdown
        e.stopPropagation();
    });

  });
});
