package buoi2;

//thuộc tính đối tượng

//=> quan hệ thành phần/ bao gồm
//Bao gói
//sao chép cạn shallow copy là việc sao chép bởi việc gán bằng cho từng thuộc tính của 2 đối tượng
//sao chép sâu deep copy là việc sao chép đầy đủ hoặc giá trị trên từng thuộc tính của 2 đối tượng
//sao chép tham chiếu reference copy cũng là sao chép cạn là thực hiện gán bằng cho 2 đối tượng(khá nguy hiểm)
//----dùng sao chép sâu tạo vùng nhớ riêng cho đối tượng để sao chép
//public Object clone() throws Exception/clone not supported exception/{super.clone();} sao chép cạn
// super clone chín là d1=dt.d1;d2=dt.d2;
// chú yếu kiểm tra tính bao gói -,.,#,+
//nạp chồng là tái định nghĩa 
//xem nạp đè 2 hàm trùng tên trùng đối số trong lớp cha và lớp con và cháu
//cùng tên hàm cùng đối số khác lớp không quan hệ bà con cha con mà chỉ là quan hêj thành phần

//viết 5 hàm xây dựng,xây dựng sao chép,nhập,in, toString