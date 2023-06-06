$(document).ready(function(){

    $('#TableID').on('click','.editBtn',function () {
        //hide edit span
        if ($(".saveBtn").is(":visible"))
        {
          //show edit span
          $(this).closest("tr").find(".editSpan").show();

          //hide edit input
          $(this).closest("tr").find(".editInput").hide();

          //show edit button
          $(this).closest("tr").find(".editBtn").show();

          //hide edit button
          $(this).closest("tr").find(".saveBtn").hide();

        }
        else {
          //hide edit span
          $(this).closest("tr").find(".editSpan").hide();

          //show edit input
          $(this).closest("tr").find(".editInput").show();

          //show edit button
          $(this).closest("tr").find(".editBtn").show();

          //show edit button
          $(this).closest("tr").find(".saveBtn").show();
        }

    });

    $('#TableID').on('click','.saveBtn',function () {
        var trObj = $(this).closest("tr");
        var ID = $(this).closest("tr").attr('id');
        var inputData = $(this).closest("tr").find(".editInput").serialize();
        $.ajax({
            type:'POST',
            url:'http://localhost/php/employees/‏‏edit-employee.php',
            dataType: "json",
            data:'action=edit&id='+ID+'&'+inputData,
            success:function(response){
                if(response.status == 'ok'){
                    alert(response.msg);

                    trObj.find(".editSpan.fname").text(response.data.first_name);
                    trObj.find(".editSpan.lname").text(response.data.last_name);
                    trObj.find(".editSpan.username").text(response.data.username);
                    trObj.find(".editSpan.password").text(response.data.password);


                    trObj.find(".editInput.fname").text(response.data.first_name);
                    trObj.find(".editInput.lname").text(response.data.last_name);
                    trObj.find(".editInput.username").text(response.data.username);
                    trObj.find(".editInput.password").text(response.data.password);


                }else{
                    alert(response.msg);
                }
            }
        });
        $(this).closest("tr").find(".editSpan").show();
        $(this).closest("tr").find(".editInput").hide();
        $(this).closest("tr").find(".editBtn").show();
        $(this).closest("tr").find(".saveBtn").hide();
    });


    $('#TableID').on('click','.deleteBtn',function () {

      if ($(".confirmBtn").is(":visible"))
      {
        $(this).closest("tr").find(".deleteBtn").show();

        $(this).closest("tr").find(".confirmBtn").hide();
      }
      else
      {
        $(this).closest("tr").find(".deleteBtn").show();

        $(this).closest("tr").find(".confirmBtn").show();
      }

    });

    $('#TableID').on('click','.confirmBtn',function () {
        var trObj = $(this).closest("tr");
        var ID = $(this).closest("tr").attr('id');
        $.ajax({
            type:'POST',
            url:'http://localhost/php/employees/delete-employee.php',
            dataType: "json",
            data:'action=delete&id='+ID,
            success:function(response){
                if(response.status == 'ok'){
                    alert(response.msg);
                    trObj.remove();
                }else{
                    trObj.find(".confirmBtn").hide();
                    trObj.find(".deleteBtn").show();
                    alert(response.msg);
                }
            }
        });

        $(this).closest("tr").find(".deleteBtn").show();

        $(this).closest("tr").find(".confirmBtn").hide();
    });
});
