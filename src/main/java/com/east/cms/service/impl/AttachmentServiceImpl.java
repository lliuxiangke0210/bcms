package com.east.cms.service.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.east.cms.dao.AttachmentMapper;
import com.east.cms.model.Attachment;
import com.east.cms.model.AttachmentTopic;
import com.east.cms.pojo.SystemContext;
import com.east.cms.service.AttachmentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.Thumbnails.Builder;
import net.coobird.thumbnailator.geometry.Positions;

@Service("attachmentService")
public class AttachmentServiceImpl implements AttachmentService {

	public final static int IMG_WIDTH = 900;
	public final static int THUMBNAIL_WIDTH = 150;
	public final static int THUMBNAIL_HEIGHT = 110;

	@Autowired
	private AttachmentMapper attachmentDao;
	public final static String UPLOAD_PATH = "/upload/";

	@Override
	public void add(Attachment a, InputStream is) throws IOException {
		try {
			attachmentDao.add(a);
			addFile(a, is);
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
	}

	private void addFile(Attachment a, InputStream is) throws IOException {
		// 进行文件的存储
		String realPath = SystemContext.getRealPath();
		String path = realPath + "/resources/upload/";
		String thumbPath = realPath + "/resources/upload/thumbnail/";
		File fp = new File(path);
		File tfp = new File(thumbPath);
		// System.out.println(fp.exists());
		// System.out.println(tfp.exists());
		if (!fp.exists())
			fp.mkdirs();
		if (!tfp.exists())
			tfp.mkdirs();
		path = path + a.getNewName();
		thumbPath = thumbPath + a.getNewName();
		// System.out.println(path+","+thumbPath);
		if (a.getIsImg() == 1) {
			BufferedImage oldBi = ImageIO.read(is);
			int width = oldBi.getWidth();
			Builder<BufferedImage> bf = Thumbnails.of(oldBi);
			if (width > IMG_WIDTH) {
				bf.scale((double) IMG_WIDTH / (double) width);
			} else {
				bf.scale(1.0f);
			}
			bf.toFile(path);
			// 缩略图的处理
			// 1、将原图进行压缩
			BufferedImage tbi = Thumbnails.of(oldBi).scale((THUMBNAIL_WIDTH * 1.2) / width).asBufferedImage();
			// 2、进行切割并且保持
			Thumbnails.of(tbi).scale(1.0f).sourceRegion(Positions.CENTER, THUMBNAIL_WIDTH, THUMBNAIL_HEIGHT)
					.toFile(thumbPath);
		} else {
			FileUtils.copyInputStreamToFile(is, new File(path));
		}
	}

	public static void deleteAttachFiles(AttachmentTopic a) {
		String realPath = SystemContext.getRealPath();
		realPath += UPLOAD_PATH;
		new File(realPath + a.getNewName()).delete();
	}

	@Override
	public void delete(int id) {
		AttachmentTopic a = attachmentDao.load(id);
		attachmentDao.delete(id);
		deleteAttachFiles(a);
	}

	@Override
	public AttachmentTopic load(int id) {
		return attachmentDao.load(id);
	}

	@Override
	public PageInfo<Attachment> findNoUseAttachment() {
		PageHelper.startPage(1, 10);
		List<Attachment> attachments = attachmentDao.findNoUseAttachment();
		// 用PageInfo对结果进行包装
		PageInfo<Attachment> page = new PageInfo<Attachment>(attachments);
		return page;
	}

	@Override
	public void deleteNoUseAttachment() {// oo
		attachmentDao.deleteNoUseAttachment();
	}

	@Override
	public List<AttachmentTopic> listByTopic(int tid) {// oo
		return attachmentDao.listByTopic(tid);
	}

	@Override
	public List<AttachmentTopic> listIndexPic(int num) {// oo
		return attachmentDao.listIndexPic(num);
	}

	@Override
	public PageInfo<AttachmentTopic> findChannelPic(int cid) {// oo
		PageHelper.startPage(1, 10);
		List<AttachmentTopic> attachments = attachmentDao.findChannelPic(cid);// oo
		// 用PageInfo对结果进行包装
		PageInfo<AttachmentTopic> page = new PageInfo<AttachmentTopic>(attachments);
		return page;
	}

	@Override
	public List<AttachmentTopic> listAttachByTopic(int topicId) {// oo
		return attachmentDao.listAttachByTopic(topicId);
	}

	@Override
	public void updateIndexPic(int aid) {
		AttachmentTopic att = attachmentDao.load(aid);
		System.out.println(aid + "------------>");
		if (att.getIsIndexPic() == 0) {
			att.setIsIndexPic(1);
		} else {
			att.setIsIndexPic(0);
		}
		attachmentDao.update(att);

	}

	@Override
	public void updateAttachInfo(int aid) {
		AttachmentTopic att = attachmentDao.load(aid);
		if (att.getIsAttach() == 0) {
			att.setIsAttach(1);
		} else {
			att.setIsAttach(0);
		}
		attachmentDao.update(att);

	}

	@Override
	public PageInfo<AttachmentTopic> listAllPic() {// oo
		PageHelper.startPage(1, 10);
		List<AttachmentTopic> attachments = attachmentDao.listAllIndexPic();
		// 用PageInfo对结果进行包装
		PageInfo<AttachmentTopic> page = new PageInfo<AttachmentTopic>(attachments);
		return page;

	}

	@Override
	public int findNoUseAttachmentNum() {// oo
		return attachmentDao.findNoUseAttachmentNum();
	}

}
