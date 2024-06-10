package com.example.a247.DATA;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "docbao247";
    private static final int DATABASE_VERSION = 1;
    public Database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    private static final String CREATE_TABLE_ACCOUNT = "CREATE TABLE tbl_account (" +
            "UserID TEXT PRIMARY KEY," +
            "Password TEXT," +
            "Description TEXT);";
    private static final String CREATE_TABLE_PROFILE = "CREATE TABLE tbl_profile (" +
            "ProfileID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "Fullname TEXT," +
            "UserID TEXT," +
            "Phone TEXT," +
            "Address TEXT," +
            "Sex INTEGER," +
            "Description TEXT);";
    private static final String CREATE_TABLE_PAPER = "CREATE TABLE tbl_paper (" +
            "PaperID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "Title_paper TEXT," +
            "Text1_paper TEXT," +
            "Text2_paper TEXT," +
            "Img_paper TEXT," +
            "Time_paper TEXT," +
            "Date_paper TEXT," +
            "CategoryID INTEGER," +
            "Description TEXT);";
    private static final String CREATE_TABLE_CATEGORY = "CREATE TABLE tbl_category (" +
            "CategoryID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "Category_name TEXT," +
            "Link TEXT," +
            "Description TEXT);";
    private static final String CREATE_TABLE_COMMENT = "CREATE TABLE tbl_comment (" +
            "CommentID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "PaperID INTEGER," +
            "ProfileID INTEGER," +
            "Text_comment TEXT," +
            "Time_comment TEXT," +
            "Date_comment TEXT," +
            "Description TEXT);";
    private static final String CREATE_TABLE_PAPERSAVE = "CREATE TABLE tbl_paperSave (" +
            "PaperSaveID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "PaperID INTEGER," +
            "ProfileID INTEGER," +
            "Description TEXT);";
    private static final String CREATE_TABLE_CATEGORYFL = "CREATE TABLE tbl_categoryFL (" +
            "CategoryFLID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "CategoryID INTEGER," +
            "ProfileID INTEGER," +
            "Description TEXT);";
    private static final String insertAdminUser = "INSERT INTO tbl_account (UserID, Password, Description) VALUES ('Admin@gmail.com', '111', '')";

    private static final String insertCategory = "INSERT INTO tbl_category (Category_name,Link,Description) VALUES ('Thể Thao','https://vnexpress.net/rss/the-thao.rss', '')";
    private static final String insertCategory1 = "INSERT INTO tbl_category (Category_name,Link,Description) VALUES ('Chính Trị','https://vnexpress.net/rss/the-gioi.rss', '')";
    private static final String insertCategory2 = "INSERT INTO tbl_category (Category_name,Link,Description) VALUES ('Sức khoẻ','https://vnexpress.net/rss/suc-khoe.rss', '')";
    private static final String insertCategory3 = "INSERT INTO tbl_category (Category_name,Link,Description) VALUES ('Kinh doanh','https://vnexpress.net/rss/kinh-doanh.rss', '')";
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_ACCOUNT);
        db.execSQL(CREATE_TABLE_PROFILE);
        db.execSQL(CREATE_TABLE_PAPER);
        db.execSQL(CREATE_TABLE_CATEGORY);
        db.execSQL(CREATE_TABLE_PAPERSAVE);
        db.execSQL(CREATE_TABLE_COMMENT);
        db.execSQL(CREATE_TABLE_CATEGORYFL);
        db.execSQL(insertAdminUser);
        db.execSQL(insertCategory);
        db.execSQL(insertCategory1);
        db.execSQL(insertCategory2);
        db.execSQL(insertCategory3);
        String Sql = "INSERT INTO tbl_paper (Title_paper, Text1_paper, Text2_paper,Img_paper,Time_paper,Date_paper,CategoryID,Description) VALUES ('Maguire sẵn sàng hy sinh Euro 2024 để đá Cup FA','Hôm 5/5, chủ sân Old Trafford xác nhận Maguire bị đau cơ háng và vắng mặt cả bốn trận cuối tại Ngoại hạng Anh. Trung vệ 31 tuổi sẽ phải chạy đua với thời gian để mong kịp góp mặt tại chung kết FA Cup trên sân Wembley ngày 25/5.\n" +
                "\n" +
                "Dù chưa hẹn ngày trở lại, Maguire vẫn có tên trong danh sách sơ bộ 33 tuyển thủ Anh chuẩn bị dự Euro 2024 được HLV Gareth Sougate công bố hôm 21/5. Trung vệ 31 tuổi khẳng định muốn trở lại đá chung kết Cup FA, thay vì duy trì tập thể lực và hồi phục cho tới Euro 2024.\n" +
                "\n" +
                "\"Euro không phải là ưu tiên hàng đầu lúc này, nên tôi không tìm cách giữ mình cho giải đấu này\", Maguire nói với báo Anh Sunsport hôm 23/5. \"Tôi muốn thi đấu chung kết Cup FA cùng Man Utd. Việc giữ sức cho Euro chưa từng xuất hiện trong tâm trí tôi. Tôi đang làm tất cả để được trở lại đội hình Man Utd. Ngay cả khi chỉ trở lại tập luyện một ngày trước trận, tôi cũng muốn tham gia\".','Việc Maguire bị đau cơ háng là một trong 65 lượt cầu thủ Man Utd dính chấn thương mùa này. Erik ten Hag nhiều lần phàn nàn về chấn thương, khi ông không có những hậu vệ tốt nhất ở giai đoạn cuối mùa là Maguire, Raphael Varane, Lisandro Martinez, Jonny Evans, Willy Kambwala, Luke Shaw, Aaron Wan-Bissaka, Victor Lindelof và Tyrell Malacia. HLV Hà Lan cho rằng đây là nguyên nhân khiến \"Quỷ Đỏ\" trải qua mùa giải bết bát, bị loại sớm ở Champions League, Cup FA và cán đích thấp nhất lịch sử dự Ngoại hạng Anh.\n" +
                "\n" +
                "Maguire thừa nhận Man Utd trải qua mùa giải thất vọng với số ca chấn thương \"lố bịch\", nhưng cho rằng toàn đội chưa giải quyết vấn đề này không đủ tốt. \"Đáng lẽ chúng tôi phải giành nhiều điểm hơn những gì đã làm\", anh nói. \"Chúng tôi đã thi đấu chưa đủ tốt, và lẽ ra phải đá tốt hơn\".\n" +
                "\n" +
                "Trung vệ người Anh nhấn mạnh Man Utd phải thắng Man City ở chung kết Cup FA để giành vé dự Europa League, đồng thời tỏ ra bình thản trước những áp lực. \"Đó là những gì xảy ra khi bạn chơi cho CLB này\", Maguire nói. \"Nếu không đạt được kết quả tốt, các cầu thủ sẽ bị xem xét kỹ lưỡng và bị đồn đoán rời đội, còn HLV chịu nhiều áp lực. Tôi đã ở đây 5 năm, nên tôi biết chuyện gì sẽ xảy ra. Ten Hag có đủ kinh nghiệm để biết đó là một phần tất yếu của việc cống hiến cho Man Utd và ứng phó ổn\".\n" +
                "\n" +
                "Man Utd cũng gặp Man City ở chung kết Cup FA mùa trước và thua 1-2 vì cú đúp của tiền vệ Ilkay Gundogan. Maguire cho rằng Man Utd gặp khó vì để Man City mở tỷ số từ quá sớm và phải tránh kịch bản này tại Wembley ngày 25/5.\n" +
                "\n" +
                "\"Chúng tôi phải tạo ra nhiều cơ hội hơn. Nếu để Man City khởi đầu thuận lợi trong chung kết, bạn tự đẩy mình vào thế khó\", trung vệ Man Utd nói.','img_paper1','19:01','22/02/2024',1,'')";
        db.execSQL(Sql);

        String Sql1 = "INSERT INTO tbl_paper (Title_paper, Text1_paper, Text2_paper,Img_paper,Time_paper,Date_paper,CategoryID,Description) VALUES ('Gần 10.000 căn hộ tái định cư bỏ trống, nợ phí quản lý','Gần 9.000 căn hộ tái định cư bỏ trống, nợ phí quản lý','Gần 9.000 căn hộ tái định cư bỏ trống, nợ phí quản lý','img','19:55','22/02/2024',1,'')";
        db.execSQL(Sql1);
        String Sql2 = "INSERT INTO tbl_paper (Title_paper, Text1_paper, Text2_paper,Img_paper,Time_paper,Date_paper,CategoryID,Description) VALUES ('Khi marathon trở thành mốt thể thao ở Trung Quốc','Một ngày cuối tháng 4/2024, huyện Đại Hưng ở ngoại ô Bắc Kinh bỗng trở nên đông đúc. 6.000 người tụ hội về đây để dự giải bán marathon Đại Hưng, giải đấu tự đặt tên là \"Marathon Bông hoa Bắc Kinh\", dù không có cự ly full marathon, với ý tưởng để người tham dự chạy giữa những con đường hoa.','Đại Hưng không phải lựa chọn hàng đầu, nhưng vẫn thu hút nhiều VĐV tham gia do những người này không thể đăng ký tham dự nhưng giải lớn hơn. Một tuần trước đó, giải bán marathon nổi tiếng nhất Bắc Kinh được tổ chức ở quảng trường Thiên An Môn với quy mô 20.000 runner, nhưng vẫn có rất nhiều người chậm chân nên không có suất.\n" +
                "\n" +
                "Những giải marathon hàng đầu Trung Quốc ở Bắc Kinh, Thượng Hải hay Hạ Môn chưa thu hút những chân chạy trứ danh ở tầm quốc tế như Boston, London hay Tokyo, nhưng vẫn ghi nhận số lượng người đăng ký khổng lồ. Giải Bắc Kinh Marathon tháng 10/2023 có đến 130.000 người tranh nhau 30.000 suất tham dự. Tuy nhiên, con số này vẫn nhỏ khi so với giải marathon ở Vô Tích, là giải tuyển chọn VĐV dự Olympic Paris 2024 của Trung Quốc, với 265.000 người đăng ký cho 33.000 suất.\n" +
                "\n" +
                "Ở Trùng Khánh, thành phố phía Tây Nam Trung Quốc, giải marathon thu hút 100.000 người đăng ký chỉ trong một ngày, và chỉ 4% trong số đó được ra vạch xuất phát qua hình thức quay số ngẫu nhiên. Tháng trước, chỉ trong một dịp cuối tuần, 500.000 runner thi đấu ở 50 giải marathon trên toàn lãnh thổ Trung Quốc.\n" +
                "\n" +
                "Không chỉ marathon, các cự ly chạy ngắn hơn cũng trở nên phổ biến. Theo khảo sát của Hiệp hội Hàng Thể thao Trung Quốc, chạy bộ là môn thể thao được yêu thích nhất quốc gia này với 58% người được hỏi cho biết từng tham gia giải chạy, tăng so với 48% của năm 2020. Riêng năm 2023, 6 triệu người Trung Quốc tham gia 699 giải chạy đường dài.\n" +
                "\n" +
                "\"Năm nay, người người, nhà nhà đổ xô đi chạy marathon\", Shine Zhang, một nhân viên IT tham dự giải bán marathon Đại Hưng cho biết. Theo runner này, tác động của Covid-19 đã khiến người Trung Quốc quan tâm nhiều hơn đến sức khỏe, và chạy bộ là cách phổ biến nhất để rèn luyện.','img_paper2','19:55','22/02/2024',1,'')";
        db.execSQL(Sql2);
        String Sql3 = "INSERT INTO tbl_paper (Title_paper, Text1_paper, Text2_paper,Img_paper,Time_paper,Date_paper,CategoryID,Description) VALUES ('Kyle Walker: Arsenal thiếu may mắn vì phải đối đầu Man City quá mạnh','ANHTrong cuộc phỏng vấn với Sky Sports, đội trưởng Kyle Walker đánh giá cao Arsenal, ca ngợi HLV Pep Guardiola và tin rằng Man City hoàn toàn xứng đáng với chức vô địch Ngoại hạng Anh.','Sau nhiều ngày đứng dưới, nhờ Aston Villa đánh bại Arsenal 2-0 ở vòng 33 trên sân Emirates hôm 14/4, Man City vượt lên và duy trì lợi thế đến hết mùa. Thầy trò Pep Guardiola trở thành đội đầu tiên vô địch Anh bốn lần liên tiếp, vượt qua thành tích ba lần liền đăng quang của Huddersfield Town (thời 1924-1926), Arsenal (1933-1935), Liverpool (1982-1984) và Man Utd (1999-2001, 2007-2009).\n" +
                "\n" +
                "Kyle Walker sinh năm 1990, khoác áo Man City từ năm 2017 với giá chuyển nhượng 64,6 triệu USD - kỷ lục thế giới cho một hậu vệ ở thời điểm đó. Anh đóng góp lớn vào 17 danh hiệu của Man City, trong đó có sáu chức vô địch Ngoại hạng Anh và một Champions League. Walker được gọi lên tuyển Anh từ năm 2011, đã ra sân 82 trận, ghi một bàn và cùng \"Tam sư\" về nhì tại Euro 2020.','img_paper4','19:55','22/02/2024',1,'')";
        db.execSQL(Sql3);
        String Sql4 = "INSERT INTO tbl_paper (Title_paper, Text1_paper, Text2_paper,Img_paper,Time_paper,Date_paper,CategoryID,Description) VALUES ('Kyle Walker: Arsenal thiếu may mắn vì phải đối đầu Man City quá mạnh','ANHTrong cuộc phỏng vấn với Sky Sports, đội trưởng Kyle Walker đánh giá cao Arsenal, ca ngợi HLV Pep Guardiola và tin rằng Man City hoàn toàn xứng đáng với chức vô địch Ngoại hạng Anh.','Sau nhiều ngày đứng dưới, nhờ Aston Villa đánh bại Arsenal 2-0 ở vòng 33 trên sân Emirates hôm 14/4, Man City vượt lên và duy trì lợi thế đến hết mùa. Thầy trò Pep Guardiola trở thành đội đầu tiên vô địch Anh bốn lần liên tiếp, vượt qua thành tích ba lần liền đăng quang của Huddersfield Town (thời 1924-1926), Arsenal (1933-1935), Liverpool (1982-1984) và Man Utd (1999-2001, 2007-2009).\n" +
                "\n" +
                "Kyle Walker sinh năm 1990, khoác áo Man City từ năm 2017 với giá chuyển nhượng 64,6 triệu USD - kỷ lục thế giới cho một hậu vệ ở thời điểm đó. Anh đóng góp lớn vào 17 danh hiệu của Man City, trong đó có sáu chức vô địch Ngoại hạng Anh và một Champions League. Walker được gọi lên tuyển Anh từ năm 2011, đã ra sân 82 trận, ghi một bàn và cùng \"Tam sư\" về nhì tại Euro 2020.','img_paper3','19:55','22/02/2024',1,'')";
        db.execSQL(Sql4);
        String Sql5 = "INSERT INTO tbl_paper (Title_paper, Text1_paper, Text2_paper,Img_paper,Time_paper,Date_paper,CategoryID,Description) VALUES ('Việt Nam giành HC vàng châu Á chạy tiếp sức 4x400m nữ.','ANHTrong cuộc phỏng vấn với Sky Sports, đội trưởng Kyle Walker đánh giá cao Arsenal, ca ngợi HLV Pep Guardiola và tin rằng Man City hoàn toàn xứng đáng với chức vô địch Ngoại hạng Anh.','Sau nhiều ngày đứng dưới, nhờ Aston Villa đánh bại Arsenal 2-0 ở vòng 33 trên sân Emirates hôm 14/4, Man City vượt lên và duy trì lợi thế đến hết mùa. Thầy trò Pep Guardiola trở thành đội đầu tiên vô địch Anh bốn lần liên tiếp, vượt qua thành tích ba lần liền đăng quang của Huddersfield Town (thời 1924-1926), Arsenal (1933-1935), Liverpool (1982-1984) và Man Utd (1999-2001, 2007-2009).\n" +
                "\n" +
                "Kyle Walker sinh năm 1990, khoác áo Man City từ năm 2017 với giá chuyển nhượng 64,6 triệu USD - kỷ lục thế giới cho một hậu vệ ở thời điểm đó. Anh đóng góp lớn vào 17 danh hiệu của Man City, trong đó có sáu chức vô địch Ngoại hạng Anh và một Champions League. Walker được gọi lên tuyển Anh từ năm 2011, đã ra sân 82 trận, ghi một bàn và cùng \"Tam sư\" về nhì tại Euro 2020.','img_paper4','19:55','22/02/2024',1,'')";
        db.execSQL(Sql5);
        String Sql11 = "INSERT INTO tbl_paper (Title_paper, Text1_paper, Text2_paper,Img_paper,Time_paper,Date_paper,CategoryID,Description) VALUES ('Gần 10.000 căn hộ tái định cư bỏ trống, nợ phí quản lý','Gần 9.000 căn hộ tái định cư bỏ trống, nợ phí quản lý','Gần 9.000 căn hộ tái định cư bỏ trống, nợ phí quản lý','img','19:55','22/02/2024',2,'')";
        db.execSQL(Sql11);
        String Sql21 = "INSERT INTO tbl_paper (Title_paper, Text1_paper, Text2_paper,Img_paper,Time_paper,Date_paper,CategoryID,Description) VALUES ('Khi marathon trở thành mốt thể thao ở Trung Quốc','Một ngày cuối tháng 4/2024, huyện Đại Hưng ở ngoại ô Bắc Kinh bỗng trở nên đông đúc. 6.000 người tụ hội về đây để dự giải bán marathon Đại Hưng, giải đấu tự đặt tên là \"Marathon Bông hoa Bắc Kinh\", dù không có cự ly full marathon, với ý tưởng để người tham dự chạy giữa những con đường hoa.','Đại Hưng không phải lựa chọn hàng đầu, nhưng vẫn thu hút nhiều VĐV tham gia do những người này không thể đăng ký tham dự nhưng giải lớn hơn. Một tuần trước đó, giải bán marathon nổi tiếng nhất Bắc Kinh được tổ chức ở quảng trường Thiên An Môn với quy mô 20.000 runner, nhưng vẫn có rất nhiều người chậm chân nên không có suất.\n" +
                "\n" +
                "Những giải marathon hàng đầu Trung Quốc ở Bắc Kinh, Thượng Hải hay Hạ Môn chưa thu hút những chân chạy trứ danh ở tầm quốc tế như Boston, London hay Tokyo, nhưng vẫn ghi nhận số lượng người đăng ký khổng lồ. Giải Bắc Kinh Marathon tháng 10/2023 có đến 130.000 người tranh nhau 30.000 suất tham dự. Tuy nhiên, con số này vẫn nhỏ khi so với giải marathon ở Vô Tích, là giải tuyển chọn VĐV dự Olympic Paris 2024 của Trung Quốc, với 265.000 người đăng ký cho 33.000 suất.\n" +
                "\n" +
                "Ở Trùng Khánh, thành phố phía Tây Nam Trung Quốc, giải marathon thu hút 100.000 người đăng ký chỉ trong một ngày, và chỉ 4% trong số đó được ra vạch xuất phát qua hình thức quay số ngẫu nhiên. Tháng trước, chỉ trong một dịp cuối tuần, 500.000 runner thi đấu ở 50 giải marathon trên toàn lãnh thổ Trung Quốc.\n" +
                "\n" +
                "Không chỉ marathon, các cự ly chạy ngắn hơn cũng trở nên phổ biến. Theo khảo sát của Hiệp hội Hàng Thể thao Trung Quốc, chạy bộ là môn thể thao được yêu thích nhất quốc gia này với 58% người được hỏi cho biết từng tham gia giải chạy, tăng so với 48% của năm 2020. Riêng năm 2023, 6 triệu người Trung Quốc tham gia 699 giải chạy đường dài.\n" +
                "\n" +
                "\"Năm nay, người người, nhà nhà đổ xô đi chạy marathon\", Shine Zhang, một nhân viên IT tham dự giải bán marathon Đại Hưng cho biết. Theo runner này, tác động của Covid-19 đã khiến người Trung Quốc quan tâm nhiều hơn đến sức khỏe, và chạy bộ là cách phổ biến nhất để rèn luyện.','img_paper2','19:55','22/02/2024',2,'')";
        db.execSQL(Sql21);
        String Sql31 = "INSERT INTO tbl_paper (Title_paper, Text1_paper, Text2_paper,Img_paper,Time_paper,Date_paper,CategoryID,Description) VALUES ('Kyle Walker: Arsenal thiếu may mắn vì phải đối đầu Man City quá mạnh','ANHTrong cuộc phỏng vấn với Sky Sports, đội trưởng Kyle Walker đánh giá cao Arsenal, ca ngợi HLV Pep Guardiola và tin rằng Man City hoàn toàn xứng đáng với chức vô địch Ngoại hạng Anh.','Sau nhiều ngày đứng dưới, nhờ Aston Villa đánh bại Arsenal 2-0 ở vòng 33 trên sân Emirates hôm 14/4, Man City vượt lên và duy trì lợi thế đến hết mùa. Thầy trò Pep Guardiola trở thành đội đầu tiên vô địch Anh bốn lần liên tiếp, vượt qua thành tích ba lần liền đăng quang của Huddersfield Town (thời 1924-1926), Arsenal (1933-1935), Liverpool (1982-1984) và Man Utd (1999-2001, 2007-2009).\n" +
                "\n" +
                "Kyle Walker sinh năm 1990, khoác áo Man City từ năm 2017 với giá chuyển nhượng 64,6 triệu USD - kỷ lục thế giới cho một hậu vệ ở thời điểm đó. Anh đóng góp lớn vào 17 danh hiệu của Man City, trong đó có sáu chức vô địch Ngoại hạng Anh và một Champions League. Walker được gọi lên tuyển Anh từ năm 2011, đã ra sân 82 trận, ghi một bàn và cùng \"Tam sư\" về nhì tại Euro 2020.','img_paper4','19:55','22/02/2024',2,'')";
        db.execSQL(Sql31);
        String Sql41 = "INSERT INTO tbl_paper (Title_paper, Text1_paper, Text2_paper,Img_paper,Time_paper,Date_paper,CategoryID,Description) VALUES ('Kyle Walker: Arsenal thiếu may mắn vì phải đối đầu Man City quá mạnh','ANHTrong cuộc phỏng vấn với Sky Sports, đội trưởng Kyle Walker đánh giá cao Arsenal, ca ngợi HLV Pep Guardiola và tin rằng Man City hoàn toàn xứng đáng với chức vô địch Ngoại hạng Anh.','Sau nhiều ngày đứng dưới, nhờ Aston Villa đánh bại Arsenal 2-0 ở vòng 33 trên sân Emirates hôm 14/4, Man City vượt lên và duy trì lợi thế đến hết mùa. Thầy trò Pep Guardiola trở thành đội đầu tiên vô địch Anh bốn lần liên tiếp, vượt qua thành tích ba lần liền đăng quang của Huddersfield Town (thời 1924-1926), Arsenal (1933-1935), Liverpool (1982-1984) và Man Utd (1999-2001, 2007-2009).\n" +
                "\n" +
                "Kyle Walker sinh năm 1990, khoác áo Man City từ năm 2017 với giá chuyển nhượng 64,6 triệu USD - kỷ lục thế giới cho một hậu vệ ở thời điểm đó. Anh đóng góp lớn vào 17 danh hiệu của Man City, trong đó có sáu chức vô địch Ngoại hạng Anh và một Champions League. Walker được gọi lên tuyển Anh từ năm 2011, đã ra sân 82 trận, ghi một bàn và cùng \"Tam sư\" về nhì tại Euro 2020.','img_paper3','19:55','22/02/2024',2,'')";
        db.execSQL(Sql41);
        String Sql51 = "INSERT INTO tbl_paper (Title_paper, Text1_paper, Text2_paper,Img_paper,Time_paper,Date_paper,CategoryID,Description) VALUES ('Việt Nam giành HC vàng châu Á chạy tiếp sức 4x400m nữ.','ANHTrong cuộc phỏng vấn với Sky Sports, đội trưởng Kyle Walker đánh giá cao Arsenal, ca ngợi HLV Pep Guardiola và tin rằng Man City hoàn toàn xứng đáng với chức vô địch Ngoại hạng Anh.','Sau nhiều ngày đứng dưới, nhờ Aston Villa đánh bại Arsenal 2-0 ở vòng 33 trên sân Emirates hôm 14/4, Man City vượt lên và duy trì lợi thế đến hết mùa. Thầy trò Pep Guardiola trở thành đội đầu tiên vô địch Anh bốn lần liên tiếp, vượt qua thành tích ba lần liền đăng quang của Huddersfield Town (thời 1924-1926), Arsenal (1933-1935), Liverpool (1982-1984) và Man Utd (1999-2001, 2007-2009).\n" +
                "\n" +
                "Kyle Walker sinh năm 1990, khoác áo Man City từ năm 2017 với giá chuyển nhượng 64,6 triệu USD - kỷ lục thế giới cho một hậu vệ ở thời điểm đó. Anh đóng góp lớn vào 17 danh hiệu của Man City, trong đó có sáu chức vô địch Ngoại hạng Anh và một Champions League. Walker được gọi lên tuyển Anh từ năm 2011, đã ra sân 82 trận, ghi một bàn và cùng \"Tam sư\" về nhì tại Euro 2020.','img_paper4','19:55','22/02/2024',2,'')";
        db.execSQL(Sql51);
        String AddComment1 = "INSERT INTO tbl_comment(PaperID,ProfileID,Text_comment,Time_comment,Date_comment,Description) VALUES(1,1,'Day la comment 1','19:11','22/02/2024','')";
        String AddComment2 = "INSERT INTO tbl_comment(PaperID,ProfileID,Text_comment,Time_comment,Date_comment,Description) VALUES(1,1,'Day la comment 1','11:11','22/02/2024','')";
        String AddComment3 = "INSERT INTO tbl_comment(PaperID,ProfileID,Text_comment,Time_comment,Date_comment,Description) VALUES(2,1,'Day la comment bai 2','12:11','22/02/2024','')";
        String AddComment4 = "INSERT INTO tbl_comment(PaperID,ProfileID,Text_comment,Time_comment,Date_comment,Description) VALUES(2,1,'Day la comment 22','13:11','22/02/2024','')";
        String AddComment5 = "INSERT INTO tbl_comment(PaperID,ProfileID,Text_comment,Time_comment,Date_comment,Description) VALUES(3,1,'Day la comment 33','09:11','22/02/2024','')";
        db.execSQL(AddComment1);
        db.execSQL(AddComment2);
        db.execSQL(AddComment3);
        db.execSQL(AddComment4);
        db.execSQL(AddComment5);
        String AddProfile1 = "INSERT INTO tbl_profile(Fullname,UserID,Phone,Address,Sex,Description) VALUES('Van A','VanA@gmail.com','09999999','Nghe An',1,'')";
        String AddProfile2 = "INSERT INTO tbl_profile(Fullname,UserID,Phone,Address,Sex,Description) VALUES('Ho Van Long','VanLong@gmail.com','09999999','Nghe An',1,'')";
        db.execSQL(AddProfile1);
        db.execSQL(AddProfile2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
