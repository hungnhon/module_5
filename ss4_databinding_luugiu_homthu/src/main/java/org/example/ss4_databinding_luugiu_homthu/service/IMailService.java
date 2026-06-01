package org.example.ss4_databinding_luugiu_homthu.service;

import org.example.ss4_databinding_luugiu_homthu.model.MailSetting;

public interface IMailService {

    MailSetting getSetting();

    void update(MailSetting mailSetting);
}