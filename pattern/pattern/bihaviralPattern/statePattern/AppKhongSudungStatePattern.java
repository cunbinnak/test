/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pattern.bihaviralPattern.statePattern; 
enum DocumentState {
    NEW, SUBMITTED, APPROVED, REJECTED
} 
class DocumentService {
    private DocumentState state; 
    public void setState(DocumentState state) {
        this.state = state;
    } 
    public void handleRequest() {
        switch (state) {
        case NEW:
            System.out.println("Create a new document");
            break;
        case SUBMITTED:
            System.out.println("Submitted");  break;
        case APPROVED:
            System.out.println("Approved");  break;
        case REJECTED:
            System.out.println("Rejected");   break; 
        default:   break;
        }
    }
}
/*
Như bạn thấy chương trình trên chạy ok, không vấn đề gì. 
Nhưng bây giờ chúng ta muốn thêm một trạng thái mới như lưu nháp (Save Draft).
Đơn giản chúng ta chỉ cần thêm vào enum một giá trị mới 
và thêm điều kiện xử lý trong switch-case. 
Tuy nhiên, nếu làm như vậy thì chúng ta đã vi phạm nguyên tắc Open/ Close.
Mỗi khi có thêm một trạng thái mới chúng ta phải sửa nhiều nơi, 
code trong phương thức handleRequest() ngày càng nhiều
và cần phải test lại toàn bộ app.
*/
 
public class AppKhongSudungStatePattern {
    public static void main(String[] args) {
        DocumentService service = new DocumentService();
 
        service.setState(DocumentState.NEW);
        service.handleRequest();
 
        service.setState(DocumentState.SUBMITTED);
        service.handleRequest();
 
        service.setState(DocumentState.APPROVED);
        service.handleRequest();
    }
}