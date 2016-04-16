package com.east.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.east.cms.auth.AuthClass;
import com.east.cms.pojo.SystemContext;
import com.east.cms.utils.BackupFileUtil;

@AuthClass
@Controller
@RequestMapping("/admin")
public class BackupController {

	/*
	 * @Autowired private IndexService indexService;
	 */

	@RequestMapping(value = "/backup/add", method = RequestMethod.GET)
	public String backup() {
		return "backup/add";
	}

	@RequestMapping(value = "/backup/add", method = RequestMethod.POST)
	public String backup(String backupFilename) {
		BackupFileUtil bfu = BackupFileUtil.getInstance(SystemContext.getRealPath());
		bfu.backup(backupFilename);
		return "redirect:/admin/backups";
	}

	@RequestMapping(value = "/backups")
	public String list(Model model) {
		BackupFileUtil bfu = BackupFileUtil.getInstance(SystemContext.getRealPath());
		model.addAttribute("backups", bfu.listBackups());
		return "backup/list";
	}

	@RequestMapping("delete/{name}")
	public String delete(@PathVariable String name, String type) {
		BackupFileUtil bfu = BackupFileUtil.getInstance(SystemContext.getRealPath());
		bfu.delete(name + "." + type);
		return "redirect:/admin/backups";
	}

	/*
	 * @RequestMapping("resume/{name}") public String resume(@PathVariable
	 * String name, String type) { BackupFileUtil bfu =
	 * BackupFileUtil.getInstance(SystemContext.getRealPath()); bfu.resume(name
	 * + "." + type); indexService.generateTop(); indexService.generateBody();
	 * indexService.generateBottom(); return "redirect:/admin/backups"; }
	 */

}
