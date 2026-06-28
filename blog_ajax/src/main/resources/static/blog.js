loadBlogs();

function loadBlogs() {

    $.ajax({
        url: "/api/blogs",
        type: "GET",

        success: function (blogs) {

            let html = "";

            for (let blog of blogs) {

                html += `
                    <tr>
                        <td>${blog.id}</td>
                        <td>${blog.title}</td>
                        <td>${blog.content}</td>
                        <td>${blog.category.name}</td>
                    </tr>
                `;
            }

            $("#blogBody").html(html);
        }
    });
}

$("#btnSearch").click(function () {

    let keyword = $("#keyword").val();

    $.ajax({
        url:
            "/api/blogs/search?keyword="
            + keyword,

        type: "GET",

        success: function (blogs) {

            let html = "";

            for (let blog of blogs) {

                html += `
                    <tr>
                        <td>${blog.id}</td>
                        <td>${blog.title}</td>
                        <td>${blog.content}</td>
                        <td>${blog.category.name}</td>
                    </tr>
                `;
            }

            $("#blogBody").html(html);
        }
    });

});