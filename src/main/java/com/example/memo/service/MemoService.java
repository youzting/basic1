package com.example.memo.service;

import com.example.memo.dto.*;
import com.example.memo.entity.Memo;
import com.example.memo.repository.MemoRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;


@Service
@RequiredArgsConstructor
public class MemoService {
    private final MemoRepository memoRepository;

    @Transactional
    public MemoCreateResponse save(MemoCreateRequest request){
        Memo memo = new Memo(request.getText());
        Memo savedMemo = memoRepository.save(memo);
        return new MemoCreateResponse(
                memo.getId(),
                memo.getText(),
                memo.getCreatedAt(),
                memo.getModifiedAt()
        );
    }

    @Transactional(readOnly = true)
    public List<MemoGetResponse> findAll(){
        List<Memo> memos = memoRepository.findAll();
        List<MemoGetResponse> dtos =  new ArrayList<>();
        for (Memo memo : memos) {
            MemoGetResponse dto = new MemoGetResponse(
                    memo.getId(),
                    memo.getText(),
                    memo.getCreatedAt(),
                    memo.getModifiedAt()
            );
            dtos.add(dto);
        }
        return dtos;

    }

    @Transactional(readOnly = true)
    public MemoGetResponse findOne(Long memoId){
        Memo memo = memoRepository.findById(memoId).orElseThrow(
                () -> new IllegalStateException("메모가 없음")
        );
        return new MemoGetResponse(
                memo.getId(),
                memo.getText(),
                memo.getCreatedAt(),
                memo.getModifiedAt()
        );
    }

    @Transactional
    public MemoUpdateResponse update(Long memoId, MemoUpdateRequest request){
        Memo memo = memoRepository.findById(memoId).orElseThrow(
                () -> new IllegalStateException("메모가 없음")
        );
        memo.update(request.getText());
        return new MemoUpdateResponse(
                memo.getId(),
                memo.getText(),
                memo.getCreatedAt(),
                memo.getModifiedAt()
        );
    }

    @Transactional
    public void delete(Long memoId){
        boolean existence = memoRepository.existsById(memoId);
        if (!existence){
            throw new IllegalStateException("메모가 없음");
        }
        memoRepository.deleteById(memoId);
    }

}
