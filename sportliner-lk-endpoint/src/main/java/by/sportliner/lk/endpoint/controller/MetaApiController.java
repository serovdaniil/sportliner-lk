package by.sportliner.lk.endpoint.controller;

import by.sportliner.lk.endpoint.api.MetaApi;
import by.sportliner.lk.endpoint.api.VersionsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MetaApiController implements MetaApi {

    @Autowired
    private BuildProperties buildProperties;

    @Override
    public ResponseEntity<VersionsDto> getVersions() {
        return ResponseEntity.ok(new VersionsDto()
            .version(buildProperties.getVersion())
        );
    }
}
