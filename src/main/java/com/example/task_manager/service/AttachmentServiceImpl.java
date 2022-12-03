package com.example.task_manager.service;

import com.example.task_manager.domin.Attachment;
import com.example.task_manager.repos.AttachmentRepo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AttachmentServiceImpl implements AttachmentService{

    private final AttachmentRepo attachmentRepo;

    public AttachmentServiceImpl(AttachmentRepo attachmentRepo) {
        this.attachmentRepo = attachmentRepo;
    }

    @Override
    public Attachment saveAttachment(MultipartFile file) throws Exception {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if(fileName.contains("..")){
                throw new Exception("Filename contains invalid path sequence"
                + fileName);
            }

            Attachment attachment
                    = new Attachment(fileName,
                    file.getContentType(),
                    file.getBytes());
            return attachmentRepo.save(attachment);
        }catch (Exception e) {
            throw new Exception("Could not save file: " + fileName);
        }
    }

    @Override
    public Attachment getAttachment(String fileId) throws Exception {
        return attachmentRepo
                .findById(fileId)
                .orElseThrow(()->new Exception("File not found with id " + fileId));
    }
}
