package kz.fakewhatsapp.fakewhatsapp.dto;

import org.springframework.web.multipart.MultipartFile;

public class FileReq {
    private MultipartFile file;
    private double fileSize;
    private String filename;

    public FileReq(MultipartFile file, double fileSize, String filename) {
        this.file = file;
        this.fileSize = fileSize;
        this.filename = filename;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public double getFileSize() {
        return fileSize;
    }

    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public String toString() {
        return "FileReq{" +
                "file=" + file +
                ", fileSize=" + fileSize +
                ", filename='" + filename + '\'' +
                '}';
    }
}
