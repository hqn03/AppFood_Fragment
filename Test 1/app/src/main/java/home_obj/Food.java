package home_obj;

public class Food {
    private String tenMonAn;
    private double gia;
    private int hinhAnh;
    private double danhGia;

    public Food(String tenMonAn, double gia, int hinhAnh, double danhGia) {
        this.tenMonAn = tenMonAn;
        this.gia = gia;
        this.hinhAnh = hinhAnh;
        this.danhGia = danhGia;
    }

    public String getTenMonAn() {
        return tenMonAn;
    }

    public void setTenMonAn(String tenMonAn) {
        this.tenMonAn = tenMonAn;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public int getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(int hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public double getDanhGia() {
        return danhGia;
    }

    public void setDanhGia(double danhGia) {
        this.danhGia = danhGia;
    }
}
