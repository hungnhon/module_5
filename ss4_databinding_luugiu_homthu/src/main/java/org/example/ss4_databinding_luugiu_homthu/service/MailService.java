package org.example.ss4_databinding_luugiu_homthu.service;

import org.example.ss4_databinding_luugiu_homthu.model.MailSetting;
import org.springframework.stereotype.Service;

@Service
public class MailService implements IMailService {

    private static MailSetting setting =
            new MailSetting(
                    "English",
                    25,
                    true,
                    "Thor\nKing, Asgard"
            );

    @Override
    public MailSetting getSetting() {
        return setting;
    }

    @Override
    public void update(MailSetting mailSetting) {
        setting = mailSetting;
    }
}