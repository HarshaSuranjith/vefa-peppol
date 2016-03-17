package no.difi.vefa.peppol.security.mode;

import no.difi.vefa.peppol.security.api.ModeDescription;
import no.difi.vefa.peppol.common.code.Service;
import no.difi.vefa.peppol.security.Mode;

import java.io.InputStream;

public class TestMode implements ModeDescription {

    private static String[] issuersAp = new String[] {"PEPPOL ACCESS POINT TEST CA"};
    private static String[] issuersSmp = new String[] {"PEPPOL SERVICE METADATA PUBLISHER TEST CA"};

    @Override
    public String getIdentifier() {
        return Mode.TEST;
    }

    @Override
    public String[] getIssuers(Service service) {
        switch (service) {
            case AP:
                return issuersAp;
            case SMP:
                return issuersSmp;
        }
        return new String[0];
    }

    @Override
    public InputStream getKeystore() {
        return getClass().getResourceAsStream("/peppol-test.jks");
    }
}
