package no.difi.vefa.edelivery.lookup.fetcher;

import no.difi.vefa.edelivery.lookup.api.LookupException;
import no.difi.vefa.edelivery.lookup.api.MetadataFetcher;
import no.difi.vefa.edelivery.lookup.model.FetcherResponse;

import java.io.BufferedInputStream;
import java.net.URI;

public class UrlFetcher implements MetadataFetcher {

    @Override
    public FetcherResponse fetch(URI uri) throws LookupException {
        try {
            return new FetcherResponse(new BufferedInputStream(uri.toURL().openStream()), null);
        } catch (Exception e) {
            throw new LookupException(e.getMessage(), e);
        }
    }
}